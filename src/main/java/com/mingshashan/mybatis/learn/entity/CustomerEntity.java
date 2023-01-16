package com.mingshashan.mybatis.learn.entity;

import lombok.Data;

/**
 * 客户entity
 */
@Data
public class CustomerEntity extends BaseEntity {

    /**
     * 名称
     */
    private String name;

    /**
     * 电话
     */
    private String phone;

    /**
     * 性别
     */
    private int gender;

    /**
     * 收货地址(json格式存)-值对象
     */
    private String addressInfo;
}
