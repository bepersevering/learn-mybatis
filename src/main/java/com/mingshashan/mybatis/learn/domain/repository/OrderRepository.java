package com.mingshashan.mybatis.learn.domain.repository;

import com.mingshashan.mybatis.learn.domain.Order;

import java.util.List;

/**
 * order repository
 */
public interface OrderRepository {

    /**
     * save order
     *
     * @param order
     * @return
     */
    Integer insertOrderEntity(Order order);

    /**
     * get by id
     *
     * @param id
     * @return
     */
    Order getById(String id);

    /**
     * get by customer id
     *
     * @param customerId
     * @return
     */
    List<Order> getByCustomerId(String customerId);

    /**
     * delete by id
     *
     * @param id
     * @return
     */
    Integer deleteById(String id);
}
