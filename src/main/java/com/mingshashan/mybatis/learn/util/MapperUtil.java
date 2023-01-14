package com.mingshashan.mybatis.learn.util;

import com.mingshashan.mybatis.learn.dao.exception.DaoException;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author mingshashan
 */
public class MapperUtil {

    private static Map<String, MapperDelegate> mapperHolder = new ConcurrentHashMap<>();

    public static <T> T getMapperInstance(Class<T> clazz) {

        if (null == clazz) {
            throw new DaoException("clazz is empty");
        }

        String className = clazz.getName();

        if (!mapperHolder.containsKey(className)) {
            throw new DaoException("no mapper " + className);
        }

        MapperDelegate mapperDelegate = mapperHolder.get(className);

        return (T) mapperDelegate.getMapper();
    }

    public void addMapper(String key, MapperDelegate mapperDelegate) {
        mapperHolder.put(key, mapperDelegate);
    }
}
