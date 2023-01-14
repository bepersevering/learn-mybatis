package com.mingshashan.mybatis.learn.domain.repository;

import com.mingshashan.mybatis.learn.domain.Product;

/**
 * product repository
 */
public interface ProductRepository {

    /**
     * 保存Product
     *
     * @param Product
     */
    void saveProduct(Product Product);

    /**
     * 更新Product
     *
     * @param Product Product
     */
    void updateProduct(Product Product);

    /**
     * 根据用户id删除Product
     *
     * @param id
     */
    void deleteProductById(String id);

    /**
     * 根据用户id查询Product
     *
     * @param id Product id
     */
    Product findById(String id);
}
