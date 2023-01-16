package com.mingshashan.mybatis.learn.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 基础字段父类
 */
@Data
public class BaseEntity {

    /**
     * 主键ID
     */
    protected String id;

    /**
     * 创建时间
     */
    protected LocalDateTime gmtCreated;

    /**
     * 修改时间
     */
    protected LocalDateTime gmtModified;

    /**
     * 有效标识
     */
    protected Integer isValid;
}
