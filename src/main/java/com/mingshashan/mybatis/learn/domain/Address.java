package com.mingshashan.mybatis.learn.domain;

import lombok.Data;

/**
 * 地址
 */
@Data
public class Address {
    /**
     * 省
     */
    private String province;

    /**
     * 市
     */
    private String city;

    /**
     * 区
     */
    private String district;

    /**
     * 街道
     */
    private String street;
}
