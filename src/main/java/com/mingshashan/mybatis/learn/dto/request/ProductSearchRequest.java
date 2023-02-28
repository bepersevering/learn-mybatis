package com.mingshashan.mybatis.learn.dto.request;

import lombok.Data;

/**
 * @author mingshashan
 */
@Data
public class ProductSearchRequest {

    private int pageIndex;
    private int pageSize;

    /**
     * 产品名
     */
    private String name;

    /**
     * 商品类型
     */
    private String categoryCode;

}
