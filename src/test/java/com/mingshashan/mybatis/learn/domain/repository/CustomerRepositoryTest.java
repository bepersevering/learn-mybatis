package com.mingshashan.mybatis.learn.domain.repository;

import com.mingshashan.mybatis.learn.dao.CustomerRepositoryImpl;
import com.mingshashan.mybatis.learn.domain.Address;
import com.mingshashan.mybatis.learn.domain.Customer;
import com.mingshashan.mybatis.learn.util.IdGenerator;
import com.mingshashan.mybatis.learn.util.MybatisConfigUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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
    @Test
    public void saveCustomer_Common_Test() {
        Customer customer = new Customer();
        customer.setId(new IdGenerator().nextStringId());
        customer.setName("史强");
        customer.setGender(1);
        customer.setPhone("18199133882");
        List<Address> addressList = new ArrayList<>();
        Address address1 = new Address();
        address1.setProvince("东海省");
        address1.setCity("海东市");
        address1.setDistrict("东城区");
        address1.setStreet("十康街道");

        Address address2 = new Address();
        address2.setProvince("东海省");
        address2.setCity("海东市");
        address2.setDistrict("安源区");
        address2.setStreet("五里铺街道");

        addressList.add(address1);
        addressList.add(address2);
        customer.setAddressList(addressList);

        customerRepository.saveCustomer(customer);
    }

    public void saveCustomer_Exception_Test() {


    }

}
