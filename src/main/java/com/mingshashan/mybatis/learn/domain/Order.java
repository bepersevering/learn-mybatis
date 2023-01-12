package com.mingshashan.mybatis.learn.domain;

import lombok.Data;

import java.util.List;

/**
 * 订单
 */
@Data
public class Order {

    /**
     * 订单号
     */
    private String id;

    /**
     * 客户
     */
    private Customer customer;

    /**
     * 订单条目
     */
    private List<OrderItem> orderItemList;
}
