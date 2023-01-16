package com.mingshashan.mybatis.learn.dao;

import com.mingshashan.mybatis.learn.dao.conveter.OrderConverter;
import com.mingshashan.mybatis.learn.dao.mapper.OrderItemMapper;
import com.mingshashan.mybatis.learn.dao.mapper.OrderMapper;
import com.mingshashan.mybatis.learn.domain.Order;
import com.mingshashan.mybatis.learn.domain.repository.OrderRepository;
import com.mingshashan.mybatis.learn.entity.OrderEntity;
import com.mingshashan.mybatis.learn.entity.OrderItemEntity;
import com.mingshashan.mybatis.learn.util.MapperUtil;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrderRepositoryImpl implements OrderRepository {

    private final static Class<OrderMapper> mapperClass = OrderMapper.class;

    private final static Class<OrderItemMapper> itemMapperClass = OrderItemMapper.class;

    @Override
    public Integer insertOrderEntity(Order order) {
        OrderEntity orderEntity =
                OrderConverter.order2Entity(order);
        return MapperUtil.getMapperInstance(mapperClass).saveOrder(orderEntity);
    }

    @Override
    public Order getById(String id) {
        OrderEntity orderEntity = MapperUtil.
                getMapperInstance(mapperClass).getById(id);

        List<OrderItemEntity> orderItemEntityList =
                MapperUtil.getMapperInstance(itemMapperClass).getByOrderId(id);

        return OrderConverter.Entity2Order(orderEntity, orderItemEntityList);
    }

    @Override
    public List<Order> getByCustomerId(String customerId) {

        List<OrderEntity> orderEntityList =
                MapperUtil.
                        getMapperInstance(mapperClass).getByCustomerId(customerId);

        if (CollectionUtils.isEmpty(orderEntityList)) {
            return new ArrayList<>();
        }

        List<Order> orderList = new ArrayList<>();
        for (OrderEntity orderEntity : orderEntityList) {
            List<OrderItemEntity> orderItemEntityList =
                    MapperUtil.getMapperInstance(itemMapperClass).getByOrderId(orderEntity.getId());

            orderList.add(OrderConverter.Entity2Order(orderEntity, orderItemEntityList));
        }

        return orderList;
    }

    @Override
    public Integer deleteById(String id) {
        return Optional.ofNullable(MapperUtil.
                getMapperInstance(mapperClass).deleteById(id))
                .orElse(0);

    }
}
