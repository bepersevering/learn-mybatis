package com.mingshashan.mybatis.learn.util;

import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * @author mingshashan
 */
public class MapperDelegate<T> {

    private Configuration configuration;

    private Class mapperClass;

    private SqlSessionFactory sqlSessionFactory;

    public Object getMapper() {
        return configuration.getMapperRegistry()
                .getMapper(mapperClass, sqlSessionFactory.openSession(true));
    }

    public Class getMapperClass() {
        return mapperClass;
    }

    public void setMapperClass(Class mapperClass) {
        this.mapperClass = mapperClass;
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }

    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }
}
