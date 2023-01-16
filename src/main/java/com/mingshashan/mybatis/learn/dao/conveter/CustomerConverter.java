package com.mingshashan.mybatis.learn.dao.conveter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mingshashan.mybatis.learn.domain.Address;
import com.mingshashan.mybatis.learn.domain.Customer;
import com.mingshashan.mybatis.learn.entity.CustomerEntity;
import com.mingshashan.mybatis.learn.util.JSONUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author mingshashan
 */
public class CustomerConverter {
    public static CustomerEntity customer2Entity(Customer customer) throws JsonProcessingException {
        if (Objects.isNull(customer)) {
            return null;
        }

        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setId(customer.getId());
        customerEntity.setName(customer.getName());
        customerEntity.setGender(customer.getGender());
        customerEntity.setPhone(customer.getPhone());
        customerEntity.setAddressInfo(JSONUtil.toJSONString(customer.getAddressList()));
        return customerEntity;
    }

    public static Customer entity2Customer(CustomerEntity customerEntity) throws JsonProcessingException {
        if (Objects.isNull(customerEntity)) {
            return null;
        }

        Customer customer = new Customer();
        customer.setId(customerEntity.getId());
        customer.setName(customerEntity.getName());
        customer.setGender(customerEntity.getGender());
        customer.setPhone(customerEntity.getPhone());

        List<Address> addressList = new ArrayList<>();
        customer.setAddressList(JSONUtil.parseObject(customerEntity.getAddressInfo(),
                addressList.getClass()));
        return customer;
    }
}
