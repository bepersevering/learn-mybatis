package com.mingshashan.mybatis.learn.dao;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mingshashan.mybatis.learn.dao.conveter.CustomerConverter;
import com.mingshashan.mybatis.learn.dao.mapper.CustomerMapper;
import com.mingshashan.mybatis.learn.domain.Customer;
import com.mingshashan.mybatis.learn.domain.repository.CustomerRepository;
import com.mingshashan.mybatis.learn.entity.CustomerEntity;
import com.mingshashan.mybatis.learn.exception.BusinessException;
import com.mingshashan.mybatis.learn.util.MapperUtil;

public class CustomerRepositoryImpl implements CustomerRepository {

    private final static Class<CustomerMapper> customerClazz = CustomerMapper.class;

    @Override
    public void saveCustomer(Customer customer) {
        CustomerEntity customerEntity = null;
        try {
            customerEntity = CustomerConverter.customer2Entity(customer);
        } catch (JsonProcessingException e) {
            throw new BusinessException(e.getMessage(),
                    e.getCause());
        }
        MapperUtil.getMapperInstance(customerClazz)
                .saveCustomer(customerEntity);
    }

    @Override
    public void updateCustomer(Customer customer) {
        CustomerEntity customerEntity = null;
        try {
            customerEntity = CustomerConverter.customer2Entity(customer);
        } catch (JsonProcessingException e) {
            throw new BusinessException(e.getMessage(),
                    e.getCause());
        }
        MapperUtil.getMapperInstance(customerClazz)
                .updateCustomer(customerEntity);
    }

    @Override
    public void deleteCustomerById(String id) {
        MapperUtil.getMapperInstance(customerClazz)
                .deleteCustomerById(id);
    }

    @Override
    public Customer findById(String id) {
        CustomerEntity customerEntity = MapperUtil.getMapperInstance(customerClazz)
                .findById(id);
        try {
            return CustomerConverter.entity2Customer(customerEntity);
        } catch (JsonProcessingException e) {
            throw new BusinessException(e.getMessage(),
                    e.getCause());
        }
    }
}
