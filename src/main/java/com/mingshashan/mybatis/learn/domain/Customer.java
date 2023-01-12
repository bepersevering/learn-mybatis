package com.mingshashan.mybatis.learn.domain;

import java.util.List;

/**
 * 客户
 */
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
     */
    private int gender;

    /**
     * 收货地址
     */
    private List<Address> addressList;

}
