package com.mingshashan.mybatis.learn.config;

import org.mybatis.spring.SqlSessionFactoryBean;

import javax.sql.DataSource;

/**
 * @author mingshashan
 */
//@Configuration
public class MybatisConfiguration {

    //    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource) {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean;
    }
}
