package com.mingshashan.mybatis.learn.entity;

import lombok.Data;

import java.util.List;

/**
 * 订单entity
 */
@Data
public class OrderEntity extends BaseEntity {

    /**
     * 客户id
     */
    private String customerId;

    private CustomerEntity customerEntity;

    private List<OrderItemEntity> orderItemEntityList;
}
