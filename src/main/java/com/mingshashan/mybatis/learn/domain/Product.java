package com.mingshashan.mybatis.learn.domain;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 产品
 */
@Data
public class Product {

    /**
     * id
     */
    private String id;

    /**
     * 产品名
     */
    private String name;

    /**
     * 描述
     */
    private String description;

    /**
     * 价格
     */
    private BigDecimal price;
}
