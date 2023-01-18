package com.mingshashan.mybatis.learn.mybatis;

import com.mingshashan.mybatis.learn.util.JSONUtil;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.io.FileUtils;
import org.apache.ibatis.cache.Cache;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;

import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author mingshashan
 */
public class CustomCache implements Cache {

    private static final Log log = LogFactory.getLog(CustomCache.class);

    /**
     * 缓存ID默认为Mapper的namespace
     * 如：com.mingshashan.mybatis.learn.dao.mapper.CustomerMapper
     */
    private String id;
    /**
     * 读写锁
     */
    private ReadWriteLock lock = new ReentrantReadWriteLock();
    /**
     * 缓存容器
     */
    private ConcurrentMap<Object, Object> cache = new ConcurrentHashMap<>();

    /**
     * 缓存持久化到磁盘文件
     */
    private String cacheFile;

    /**
     * 会被 <cache> 的 <property> 调用
     */
    public void setCacheFile(String cacheFile) {
        this.cacheFile = cacheFile;
        log.debug("set cache file [" + cacheFile + "]");
        // 每次创建该对象时，从磁盘加载历史缓存
        try {
            File file = new File(cacheFile);
            if (!file.exists()) {
                file.createNewFile();
            }
            String str = FileUtils.readFileToString(file, "UTF-8");
            Map<Object, Object> tmpMap = JSONUtil.parseObject(str, Map.class);
            if (MapUtils.isEmpty(tmpMap)) {
                return;
            }
            for (Map.Entry<Object, Object> entry : tmpMap.entrySet()) {
                cache.put(entry.getKey(), entry.getValue());
            }
        } catch (Exception e) {
            log.error("load cache from file error", e);
        }
    }

    public CustomCache(String id) {
        this.id = id;
        log.debug("cache id = [" + id + "]");
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public int getSize() {
        return cache.size();
    }

    @Override
    public void putObject(Object key, Object value) {
        cache.put(key, value);
        // 将数据写入磁盘
        try {
            File file = new File(cacheFile);
            if (!file.exists()) {
                file.createNewFile();
            }
            String cacheStr = JSONUtil.toJSONString(cache);
            FileUtils.write(file, cacheStr, "UTF-8");
        } catch (Exception e) {
            log.error("cache persistent error", e);
        }
    }

    @Override
    public Object getObject(Object key) {
        System.out.println("getObject() key=" + key);
        return cache.get(key);
    }

    @Override
    public Object removeObject(Object key) {
        Object value = cache.get(key);
        if (null == value) {
            return null;
        } else {
            cache.remove(key);
            return value;
        }
    }

    @Override
    public void clear() {
        cache.clear();
    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        return lock;
    }
}