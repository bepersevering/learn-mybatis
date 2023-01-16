package com.mingshashan.mybatis.learn.domain;

import lombok.Data;

import java.util.List;

/**
 * 客户
 */
@Data
public class Customer {

    /**
     * 唯一id
     */
    private String id;

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
     * 1	男性
     * 2	女性
     * 0	未知
     */
    private int gender;

    /**
     * 收货地址
     */
    private List<Address> addressList;

}
