package com.mingshashan.mybatis.learn.domain.repository;

import com.mingshashan.mybatis.learn.domain.Customer;

/**
 * customer repository
 */
public interface CustomerRepository {

    /**
     * 保存customer
     *
     * @param customer
     */
    void saveCustomer(Customer customer);

    /**
     * 更新customer
     *
     * @param customer customer
     */
    void updateCustomer(Customer customer);

    /**
     * 根据用户id删除Customer
     *
     * @param id
     */
    void deleteCustomerById(String id);

    /**
     * 根据用户id查询Customer
     *
     * @param id customer id
     */
    Customer findById(String id);
}
