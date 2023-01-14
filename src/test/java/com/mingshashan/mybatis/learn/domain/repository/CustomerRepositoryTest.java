package com.mingshashan.mybatis.learn.domain.repository;

import com.mingshashan.mybatis.learn.dao.CustomerRepositoryImpl;
import com.mingshashan.mybatis.learn.util.MybatisConfigUtil;
import org.junit.After;
import org.junit.Before;

/**
 * @author mingshashan
 */
public class CustomerRepositoryTest {

    CustomerRepository customerRepository = new CustomerRepositoryImpl();

    @Before
    public void before() {
        MybatisConfigUtil mybatisConfigUtil = new MybatisConfigUtil();
        mybatisConfigUtil.init();
    }

    @After
    public void after() {

    }

    // Normal Abnormal
    // positive negative
    public void saveCustomer_Common_Test() {

    }

    public void saveCustomer_Exception_Test() {


    }

}
