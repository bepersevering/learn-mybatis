package com.mingshashan.mybatis.learn.util;

/**
 * @author mingshashan
 */
public class MapperDelegate<T> {

    private T targetMapper;

    public void setMapper(T mapper) {
        this.targetMapper = mapper;
    }

    public T getMapper() {
        return targetMapper;
    }
}
