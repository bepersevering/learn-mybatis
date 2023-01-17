package com.mingshashan.mybatis.learn.dao.conveter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mingshashan.mybatis.learn.domain.Customer;
import com.mingshashan.mybatis.learn.entity.CustomerEntity;

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
        customerEntity.setAddressList(customer.getAddressList());
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
        customer.setAddressList(customerEntity.getAddressList());
        return customer;
    }
}
