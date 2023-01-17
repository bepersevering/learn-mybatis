package com.mingshashan.mybatis.learn.entity;

import com.mingshashan.mybatis.learn.domain.Address;
import lombok.Data;

import java.util.List;

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
     * tag list
     */
    private List<TagEntity> tagEntityList;

    /**
     * 收货地址(json格式存)-值对象
     */
    private List<Address> addressList;
}
