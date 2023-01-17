package com.mingshashan.mybatis.learn.mybatis;

import org.apache.ibatis.reflection.Reflector;
import org.apache.ibatis.reflection.ReflectorFactory;
import org.apache.ibatis.util.MapUtil;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author mingshashan
 */
public class CustomReflectorFactory implements ReflectorFactory {
    private boolean classCacheEnabled = true;
    private final ConcurrentMap<Class<?>, Reflector> reflectorMap =
            new ConcurrentHashMap<>();

    public CustomReflectorFactory() {
    }

    @Override
    public boolean isClassCacheEnabled() {
        return classCacheEnabled;
    }

    @Override
    public void setClassCacheEnabled(boolean classCacheEnabled) {
        this.classCacheEnabled = classCacheEnabled;
    }

    @Override
    public Reflector findForClass(Class<?> type) {
        if (classCacheEnabled) {
            return MapUtil.computeIfAbsent(reflectorMap, type, Reflector::new);
        } else {
            return new Reflector(type);
        }
    }
}
