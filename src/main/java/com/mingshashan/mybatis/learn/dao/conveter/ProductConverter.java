package com.mingshashan.mybatis.learn.dao.conveter;

import com.mingshashan.mybatis.learn.domain.Product;
import com.mingshashan.mybatis.learn.entity.ProductEntity;

/**
 * @author mingshashan
 */
public class ProductConverter {
    public static ProductEntity product2Entity(Product product) {
        if (null == product) {
            return null;
        }

        ProductEntity productEntity = new ProductEntity();
        productEntity.setId(product.getId());
        productEntity.setName(product.getName());
        productEntity.setPrice(product.getPrice());
        productEntity.setCategoryCode(product.getCategoryCode());
        productEntity.setDescription(product.getDescription());
        return productEntity;
    }

    public static Product entity2Product(ProductEntity productEntity) {
        if (null == productEntity) {
            return null;
        }
        Product product = new Product();
        product.setId(productEntity.getId());
        product.setName(productEntity.getName());
        product.setPrice(productEntity.getPrice());
        product.setCategoryCode(productEntity.getCategoryCode());
        product.setDescription(productEntity.getDescription());
        return product;
    }
}
