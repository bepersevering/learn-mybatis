package com.mingshashan.mybatis.learn.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
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

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 总额
     */
    private BigDecimal totalPrice;
}
