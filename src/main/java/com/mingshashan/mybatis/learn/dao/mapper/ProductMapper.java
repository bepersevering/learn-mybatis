package com.mingshashan.mybatis.learn.dao.mapper;

import com.mingshashan.mybatis.learn.entity.ProductEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductMapper {

    /**
     * 保存Product
     *
     * @param ProductEntity
     */
    Integer saveProduct(ProductEntity ProductEntity);

    /**
     * 更新Product
     *
     * @param ProductEntity ProductEntity
     */
    Integer updateProduct(ProductEntity ProductEntity);

    /**
     * 根据用户id删除Product
     *
     * @param id
     */
    Integer deleteProductById(String id);

    /**
     * 根据用户id查询Product
     *
     * @param id Product id
     */
    ProductEntity findById(String id);

    /**
     * 根据分页查询条件分页查询
     * @param productEntity
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<ProductEntity> findByCondition(@Param("productEntity") ProductEntity productEntity,
                                           @Param("pageNum") Integer pageNum,
                                           @Param("pageSize") Integer pageSize);
}
