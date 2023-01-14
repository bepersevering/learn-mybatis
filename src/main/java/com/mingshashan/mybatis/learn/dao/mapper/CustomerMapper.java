package com.mingshashan.mybatis.learn.dao.mapper;

import com.mingshashan.mybatis.learn.entity.CustomerEntity;

public interface CustomerMapper {

    /**
     * 保存customer
     *
     * @param customerEntity customerEntity
     */
    Integer saveCustomer(CustomerEntity customerEntity);

    /**
     * 更新customer
     *
     * @param customerEntity customerEntity
     */
    Integer updateCustomer(CustomerEntity customerEntity);

    /**
     * 根据用户id删除Customer
     *
     * @param id
     */
    Integer deleteCustomerById(String id);

    /**
     * 根据用户id查询Customer
     *
     * @param id customer id
     */
    CustomerEntity findById(String id);
}
