package com.mingshashan.mybatis.learn.domain;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 订单条目
 */
@Data
public class OrderItem {

    /**
     * 订单条目id
     */
    private String id;

    /**
     * 产品
     */
    private Product product;

    /**
     * 数量
     */
    private Integer amount;

    /**
     * 价格
     */
    private BigDecimal price;
}
