package com.mingshashan.mybatis.learn.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 订单条目entity
 */
@Data
public class OrderItemEntity extends BaseEntity {

    /**
     * 订单id
     */
    private String orderId;

    /**
     * 产品
     */
    private String productId;

    /**
     * 数量
     */
    private Integer amount;

    /**
     * 价格
     */
    private BigDecimal price;

}
