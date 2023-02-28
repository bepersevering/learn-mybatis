package com.mingshashan.mybatis.learn.domain.service;

import com.mingshashan.mybatis.learn.copier.SpringCglibCopier;
import com.mingshashan.mybatis.learn.dao.mapper.ProductMapper;
import com.mingshashan.mybatis.learn.domain.Product;
import com.mingshashan.mybatis.learn.dto.request.ProductSearchRequest;
import com.mingshashan.mybatis.learn.entity.ProductEntity;
import com.mingshashan.mybatis.learn.util.IdGenerator;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * product service
 *
 * @author mingshashan
 */
@Service
public class ProductService {

    private final ProductMapper productMapper;
    private final SpringCglibCopier copier;

    public ProductService(ProductMapper productMapper, SpringCglibCopier copier) {
        this.productMapper = productMapper;
        this.copier = copier;
    }

    public String createProduct(Product product) throws InstantiationException, IllegalAccessException {
        ProductEntity productEntity = copier.copy(product, ProductEntity.class);
        productEntity.setId(new IdGenerator().nextStringId());
        productMapper.saveProduct(productEntity);
        return productEntity.getId();
    }

    public List<Product> queryProducts(ProductSearchRequest productSearchRequest) throws InstantiationException, IllegalAccessException {
        ProductEntity productEntity = copier.copy(productSearchRequest, ProductEntity.class);

        List<ProductEntity> productEntityList = productMapper.findByCondition(productEntity, productSearchRequest.getPageIndex(),
                productSearchRequest.getPageIndex());

        if (CollectionUtils.isEmpty(productEntityList)) {
            return new ArrayList<>();
        }

        List<Product> result = productEntityList
                .stream().map(item -> {
                            try {
                                return copier.copy(item, Product.class);
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            } catch (InstantiationException e) {
                                e.printStackTrace();
                            }
                            return null;
                        }
                )
                .collect(Collectors.toList());
        return result;
    }

}
