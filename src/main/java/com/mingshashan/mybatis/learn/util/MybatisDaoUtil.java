package com.mingshashan.mybatis.learn.util;

import org.apache.ibatis.session.SqlSession;

import java.util.function.Function;

/**
 * mybatis dao util
 */
public class MybatisDaoUtil {

    public static <R> R execute(Function<SqlSession, R> function) {
        SqlSession sqlSession = MybatisConfigUtil.getSqlSessionFactory().openSession();

        try {
            R apply = function.apply(sqlSession);
            sqlSession.commit();
            return apply;
        } catch (Throwable t) {
            sqlSession.rollback();
            throw t;
        } finally {
            // 关闭SqlSession
            sqlSession.close();
        }
    }
}
