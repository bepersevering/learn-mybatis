package com.mingshashan.mybatis.learn.entity;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * 订单条目entity
 */
@Setter
@Getter
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
