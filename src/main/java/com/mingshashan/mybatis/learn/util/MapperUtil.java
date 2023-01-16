package com.mingshashan.mybatis.learn.util;

import com.mingshashan.mybatis.learn.dao.exception.DaoException;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author mingshashan
 */
public class MapperUtil {

    private static final Map<Class, MapperDelegate> mapperHolder = new ConcurrentHashMap<>();

    public static <T> T getMapperInstance(Class<T> clazz) {

        if (null == clazz) {
            throw new DaoException("clazz is empty");
        }

        if (!mapperHolder.containsKey(clazz)) {
            throw new DaoException("no mapper " + clazz);
        }

        MapperDelegate mapperDelegate = mapperHolder.get(clazz);

        return (T) mapperDelegate.getMapper();
    }

    public static void addMapper(Class clazz, MapperDelegate mapperDelegate) {
        mapperHolder.put(clazz, mapperDelegate);
    }
}
