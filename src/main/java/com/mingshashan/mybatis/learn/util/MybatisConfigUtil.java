package com.mingshashan.mybatis.learn.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

/**
 * @author mingshashan
 */
public class MybatisConfigUtil {

    private static SqlSessionFactory sqlSessionFactory;

    static {
        String mybatisConfigFile = "mybatis-config.xml";
        // 加载mybatis-config.xml配置文件
        // 根据其中的配置信息创建SqlSessionFactory对象
        try (InputStream inputStream = Resources.getResourceAsStream(mybatisConfigFile)) {
            sqlSessionFactory = new SqlSessionFactoryBuilder()
                    .build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取sqlSessionFactory对象
     *
     * @return sqlSessionFactory
     */
    public static SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }

    public Collection<Class<?>> getMappers() {
        return sqlSessionFactory.getConfiguration().getMapperRegistry()
                .getMappers();
    }

    public void init() {
        Collection<Class<?>> mapperClassCollection = MybatisConfigUtil.getSqlSessionFactory()
                .getConfiguration()
                .getMapperRegistry().getMappers();

//        for (Class<?> clazz : mapperClassCollection) {
//            SqlSession sqlSession = sqlSessionFactory.openSession();
//            MybatisConfigUtil.getSqlSessionFactory()
//                    .getConfiguration()
//                    .getMapperRegistry().getMapper(clazz, sqlSession);
//        }
        for (Class<?> clazz : mapperClassCollection) {
            MapperDelegate mapperDelegate = new MapperDelegate();
            mapperDelegate.setConfiguration(MybatisConfigUtil.getSqlSessionFactory()
                    .getConfiguration());
            mapperDelegate.setSqlSessionFactory(sqlSessionFactory);
            mapperDelegate.setMapperClass(clazz);

            MapperUtil.addMapper(clazz, mapperDelegate);
        }
    }
}
