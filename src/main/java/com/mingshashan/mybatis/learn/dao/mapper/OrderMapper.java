package com.mingshashan.mybatis.learn.dao.mapper;

import com.mingshashan.mybatis.learn.entity.OrderEntity;

import java.util.List;

public interface OrderMapper {

    /**
     * insert order entity
     *
     * @param orderEntity
     * @return
     */
    Integer saveOrder(OrderEntity orderEntity);

    /**
     * get by id
     *
     * @param id
     * @return
     */
    OrderEntity getById(String id);

    /**
     * get by customer id
     *
     * @param customerId
     * @return
     */
    List<OrderEntity> getByCustomerId(String customerId);

    /**
     * delete by id
     *
     * @param id
     * @return
     */
    Integer deleteById(String id);
}
