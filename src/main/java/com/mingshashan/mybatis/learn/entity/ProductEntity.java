package com.mingshashan.mybatis.learn.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * product entity
 */
@Data
public class ProductEntity extends BaseEntity {

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

    /**
     * 商品类型代码
     */
    private String categoryCode;
}
