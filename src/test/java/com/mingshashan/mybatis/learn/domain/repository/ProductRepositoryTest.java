package com.mingshashan.mybatis.learn.domain.repository;

import com.mingshashan.mybatis.learn.dao.ProductRepositoryImpl;
import com.mingshashan.mybatis.learn.dao.mapper.ProductMapper;
import com.mingshashan.mybatis.learn.domain.Product;
import com.mingshashan.mybatis.learn.entity.ProductEntity;
import com.mingshashan.mybatis.learn.util.IdGenerator;
import com.mingshashan.mybatis.learn.util.MapperUtil;
import com.mingshashan.mybatis.learn.util.MybatisConfigUtil;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.exceptions.PersistenceException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author mingshashan
 */
public class ProductRepositoryTest {

    ProductRepository productRepository = new ProductRepositoryImpl();


    @Before
    public void before() {
        MybatisConfigUtil mybatisConfigUtil = new MybatisConfigUtil();
         String envId = "TEST";
         mybatisConfigUtil.init(envId);
//        mybatisConfigUtil.init();
    }

    @After
    public void after() {

    }

    // Normal Abnormal
    // positive negative
    @Test
    public void saveProduct_Common_Test() {
        Product product = new Product();
        product.setId(new IdGenerator().nextStringId());
        product.setName("红米K40Pro");
        product.setDescription("红米K40 Pro 8+128");
        product.setCategoryCode("PHONE_ANDROID_HONGMI");
        product.setPrice(new BigDecimal(1999.0));

        productRepository.saveProduct(product);
    }

    @Test
    public void saveProduct_Exception_Test() {
        Product product = new Product();
        product.setName("红米A1");
        product.setDescription("红米A1 2+32");
        product.setPrice(new BigDecimal(899.0));
        product.setCategoryCode("PHONE_ANDROID_HONGMI");

        Assert.assertThrows(PersistenceException.class,
                () -> productRepository.saveProduct(product));
    }


    @Test
    public void findById_Test() {
        Product product = new Product();
        product.setId(new IdGenerator().nextStringId());
        product.setName("红米A2");
        product.setDescription("红米A2 2+32");
        product.setPrice(new BigDecimal(899.0));
        product.setCategoryCode("PHONE_ANDROID_HONGMI");

        productRepository.saveProduct(product);

        Product saved = productRepository.findById(product.getId());

        Assert.assertTrue(StringUtils.equals(saved.getId(), product.getId()));
        Assert.assertTrue(StringUtils.equals(saved.getName(), product.getName()));
        // Assert.assertTrue(saved.getPrice(), product.getPrice());
    }

    @Test
    public void delete_Test() {
        Product product = new Product();
        product.setId(new IdGenerator().nextStringId());
        product.setName("红米A2");
        product.setDescription("红米A2 2+32");
        product.setCategoryCode("PHONE_ANDROID_HONGMI");
        product.setPrice(new BigDecimal(899.0));

        productRepository.saveProduct(product);

        Product saved = productRepository.findById(product.getId());

        Assert.assertTrue(StringUtils.equals(saved.getId(), product.getId()));
        Assert.assertTrue(StringUtils.equals(saved.getName(), product.getName()));

        productRepository.deleteProductById(product.getId());

        Product deleted = productRepository.findById(product.getId());
        Assert.assertNull(deleted);
    }

    @Test
    public void batchInsert() {
        IdGenerator idGenerator = new IdGenerator();
        for (int i = 0; i <= 30; i++) {
            ProductEntity productEntity = new ProductEntity();
            productEntity.setId(idGenerator.nextStringId());
            productEntity.setName("Meta");
            productEntity.setPrice(new BigDecimal(2000 * (1 + i) / 30));
            productEntity.setDescription("手机");
            productEntity.setCategoryCode("PHONE_HUAWEI_META");
            MapperUtil.getMapperInstance(ProductMapper.class).saveProduct(productEntity);
        }

    }

    @Test
    public void findByCondition() {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setCategoryCode("PHONE_HUAWEI_META");
        List<ProductEntity> productEntityList =
                MapperUtil.getMapperInstance(ProductMapper.class)
                .findByCondition(productEntity, 1, 2);
        System.out.println(CollectionUtils.size(productEntityList));
    }
}
