package com.mingshashan.mybatis.learn.domain.repository;

import com.mingshashan.mybatis.learn.dao.mapper.OrderItemMapper;
import com.mingshashan.mybatis.learn.dao.mapper.OrderMapper;
import com.mingshashan.mybatis.learn.entity.OrderEntity;
import com.mingshashan.mybatis.learn.entity.OrderItemEntity;
import com.mingshashan.mybatis.learn.util.IdGenerator;
import com.mingshashan.mybatis.learn.util.MapperUtil;
import com.mingshashan.mybatis.learn.util.MybatisConfigUtil;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author mingshashan
 */
public class OrderRepositoryTest {

    @Before
    public void before() {
        MybatisConfigUtil mybatisConfigUtil = new MybatisConfigUtil();
        mybatisConfigUtil.init("TEST");
    }

    @After
    public void after() {

    }


    @Test
    public void saveOrderTest() {
        List<OrderEntity> orderEntityList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            OrderEntity orderEntity = new OrderEntity();
            orderEntity.setId(new IdGenerator().nextStringId());
            orderEntity.setGmtCreated(LocalDateTime.now());
            orderEntity.setGmtModified(LocalDateTime.now());
            orderEntity.setCustomerId("cid_00" + i);
            List<OrderItemEntity> orderItemEntityList = new ArrayList<>();
            for (int j = 1; j <= 5; j++) {
                OrderItemEntity orderItemEntity = new OrderItemEntity();
                orderItemEntity.setOrderId(orderEntity.getId());
                orderItemEntity.setId(new IdGenerator().nextStringId());
                orderItemEntity.setPrice(BigDecimal.valueOf(10));
                orderItemEntity.setAmount(3);
                orderItemEntity.setProductId("P_T_0000" + i);
                orderItemEntityList.add(orderItemEntity);
                MapperUtil.getMapperInstance(OrderItemMapper.class).saveOrderItem(orderItemEntity);

            }
            orderEntity.setOrderItemEntityList(orderItemEntityList);
            orderEntityList.add(orderEntity);
            MapperUtil.getMapperInstance(OrderMapper.class).saveOrder(orderEntity);
        }

    }

    @Test
    public void getOrderById_test() {
        String orderId = "812063718803243008";

        OrderEntity orderEntity = MapperUtil.getMapperInstance(OrderMapper.class).getById(orderId);

        System.out.println(orderEntity.getCustomerId());
        List<OrderItemEntity> orderItemEntityList = orderEntity.getOrderItemEntityList();

        System.out.println(CollectionUtils.size(orderItemEntityList));
        System.out.println(orderItemEntityList.toString());
        System.out.println(CollectionUtils.size(orderItemEntityList));
    }

    @Test
    public void getOrderItemByOrderId_test() {
        String orderId = "812063718803243008";

        List<OrderItemEntity> orderItemEntityList = MapperUtil.getMapperInstance(OrderItemMapper.class).getByOrderId(orderId);
        System.out.println(orderItemEntityList.toString());
        System.out.println(CollectionUtils.size(orderItemEntityList));
    }
}
