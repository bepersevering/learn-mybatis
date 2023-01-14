package com.mingshashan.mybatis.learn.dao;

import com.mingshashan.mybatis.learn.dao.conveter.ProductConverter;
import com.mingshashan.mybatis.learn.dao.mapper.ProductMapper;
import com.mingshashan.mybatis.learn.domain.Product;
import com.mingshashan.mybatis.learn.domain.repository.ProductRepository;
import com.mingshashan.mybatis.learn.entity.ProductEntity;
import com.mingshashan.mybatis.learn.util.MapperUtil;

public class ProductRepositoryImpl implements ProductRepository {
    private final static Class<ProductMapper> mapperClazz = ProductMapper.class;

    @Override
    public void saveProduct(Product product) {
        ProductEntity productEntity = ProductConverter.product2Entity(product);
        MapperUtil.getMapperInstance(mapperClazz).saveProduct(productEntity);
    }

    @Override
    public void updateProduct(Product product) {
        ProductEntity productEntity = ProductConverter.product2Entity(product);
        MapperUtil.getMapperInstance(mapperClazz).saveProduct(productEntity);
    }

    @Override
    public void deleteProductById(String id) {
        MapperUtil.getMapperInstance(mapperClazz).deleteProductById(id);
    }

    @Override
    public Product findById(String id) {
        ProductEntity productEntity =
                MapperUtil.getMapperInstance(mapperClazz).findById(id);

        return ProductConverter.entity2Product(productEntity);
    }
}
