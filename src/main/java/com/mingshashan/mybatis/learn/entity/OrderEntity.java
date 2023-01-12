package com.mingshashan.mybatis.learn.entity;

import lombok.Data;

/**
 * 订单entity
 */
@Data
public class OrderEntity extends BaseEntity {

    /**
     * 客户id
     */
    private String customerId;
}
