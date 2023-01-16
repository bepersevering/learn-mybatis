package com.mingshashan.mybatis.learn.domain.repository;

import com.mingshashan.mybatis.learn.dao.ProductRepositoryImpl;
import com.mingshashan.mybatis.learn.domain.Product;
import com.mingshashan.mybatis.learn.util.IdGenerator;
import com.mingshashan.mybatis.learn.util.MybatisConfigUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author mingshashan
 */
public class ProductRepositoryTest {

    ProductRepository productRepository = new ProductRepositoryImpl();

    @Before
    public void before() {
        MybatisConfigUtil mybatisConfigUtil = new MybatisConfigUtil();
        mybatisConfigUtil.init();
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
        product.setPrice(new BigDecimal(1999.0));

        productRepository.saveProduct(product);
    }

    public void saveProduct_Exception_Test() {


    }

}
