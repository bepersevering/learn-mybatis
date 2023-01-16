package com.mingshashan.mybatis.learn.domain.repository;

import com.mingshashan.mybatis.learn.dao.OrderRepositoryImpl;
import com.mingshashan.mybatis.learn.util.MybatisConfigUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author mingshashan
 */
public class OrderRepositoryTest {

    OrderRepository orderRepository = new OrderRepositoryImpl();

    @Before
    public void before() {
        MybatisConfigUtil mybatisConfigUtil = new MybatisConfigUtil();
        mybatisConfigUtil.init();
    }

    @After
    public void after() {

    }


    @Test
    public void saveOrderTest() {


    }
}
