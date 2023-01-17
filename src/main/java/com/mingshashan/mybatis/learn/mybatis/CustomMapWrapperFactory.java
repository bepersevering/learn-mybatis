package com.mingshashan.mybatis.learn.mybatis;

import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.wrapper.ObjectWrapper;
import org.apache.ibatis.reflection.wrapper.ObjectWrapperFactory;

import java.util.Map;

/**
 * CustomMapWrapperFactory
 *
 * @author mingshashan
 */
public class CustomMapWrapperFactory implements ObjectWrapperFactory {
    @Override
    public boolean hasWrapperFor(Object object) {
        return object instanceof Map;
    }

    @Override
    public ObjectWrapper getWrapperFor(MetaObject metaObject, Object object) {
        return new CustomMapWrapper(metaObject, (Map<String, Object>) object);
    }
}
