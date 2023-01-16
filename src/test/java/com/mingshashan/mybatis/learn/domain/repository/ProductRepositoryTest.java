package com.mingshashan.mybatis.learn.domain.repository;

import com.mingshashan.mybatis.learn.dao.ProductRepositoryImpl;
import com.mingshashan.mybatis.learn.domain.Product;
import com.mingshashan.mybatis.learn.util.IdGenerator;
import com.mingshashan.mybatis.learn.util.MybatisConfigUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.exceptions.PersistenceException;
import org.junit.After;
import org.junit.Assert;
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

    @Test
    public void saveProduct_Exception_Test() {
        Product product = new Product();
        product.setName("红米A1");
        product.setDescription("红米A1 2+32");
        product.setPrice(new BigDecimal(899.0));

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
        product.setPrice(new BigDecimal(899.0));

        productRepository.saveProduct(product);

        Product saved = productRepository.findById(product.getId());

        Assert.assertTrue(StringUtils.equals(saved.getId(), product.getId()));
        Assert.assertTrue(StringUtils.equals(saved.getName(), product.getName()));

        productRepository.deleteProductById(product.getId());

        Product deleted = productRepository.findById(product.getId());
        Assert.assertNull(deleted);
    }
}
