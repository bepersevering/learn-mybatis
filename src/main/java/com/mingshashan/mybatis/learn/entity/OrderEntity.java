package com.mingshashan.mybatis.learn.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 订单entity
 */
@Getter
@Setter
public class OrderEntity extends BaseEntity {

    /**
     * 客户id
     */
    private String customerId;

    private CustomerEntity customerEntity;

    private List<OrderItemEntity> orderItemEntityList;
}
