package com.mingshashan.mybatis.learn;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author mingshashan
 */
@MapperScans({@MapperScan("com.mingshashan.mybatis.learn.dao.mapper")})
@SpringBootApplication
public class LearnMybatisApplication {
    public static void main(String[] args) {
        SpringApplication.run(LearnMybatisApplication.class, args);
    }
}
