package com.mingshashan.mybatis.learn.dao.conveter;

import com.mingshashan.mybatis.learn.domain.Order;
import com.mingshashan.mybatis.learn.domain.OrderItem;
import com.mingshashan.mybatis.learn.entity.OrderEntity;
import com.mingshashan.mybatis.learn.entity.OrderItemEntity;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author mingshashan
 */
public class OrderConverter {

    public static OrderEntity order2Entity(Order order) {
        if (null == order) {
            return null;
        }
        if (CollectionUtils.isEmpty(order.getOrderItemList())) {
            return null;
        }
        if (Objects.isNull(order.getCustomer())) {
            return null;
        }
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setId(order.getId());
        orderEntity.setCustomerId(order.getCustomer().getId());
        orderEntity.setOrderItemEntityList(orderItemList2Entity(order.getOrderItemList(), order.getId()));

        return orderEntity;
    }

    public static List<OrderItemEntity> orderItemList2Entity(List<OrderItem> orderItemList,
                                                             String orderId) {
        if (CollectionUtils.isEmpty(orderItemList)) {
            return new ArrayList<>();
        }

        List<OrderItemEntity> orderItemEntityList = new ArrayList<>();
        for (OrderItem orderItem : orderItemList) {
            orderItemEntityList.add(orderItem2Entity(orderItem, orderId));
        }

        return orderItemEntityList;
    }

    public static OrderItemEntity orderItem2Entity(OrderItem orderItem, String orderId) {
        if (null == orderItem) {
            return null;
        }

        OrderItemEntity orderItemEntity = new OrderItemEntity();
        orderItemEntity.setId(orderItem.getId());
        orderItemEntity.setOrderId(orderId);
        orderItemEntity.setPrice(orderItem.getPrice());
        orderItemEntity.setAmount(orderItem.getAmount());
        orderItemEntity.setProductId(orderItem.getProduct().getId());

        return orderItemEntity;
    }

    public static Order Entity2Order(OrderEntity orderEntity, List<OrderItemEntity> orderItemEntityList) {
        if (null == orderEntity || CollectionUtils.isEmpty(orderItemEntityList)) {
            return null;
        }

        Order order = new Order();
        order.setId(orderEntity.getId());
        // order.setCustomer();

        order.setOrderItemList(EntityList2OrderItem(orderItemEntityList));

        return order;
    }

    public static List<OrderItem> EntityList2OrderItem(List<OrderItemEntity> orderItemEntityList) {
        if (CollectionUtils.isEmpty(orderItemEntityList)) {
            return new ArrayList<>();
        }

        List<OrderItem> orderItemList = new ArrayList<>();
        for (OrderItemEntity orderItemEntity : orderItemEntityList) {
            orderItemList.add(entity2OrderItem(orderItemEntity));
        }

        return orderItemList;
    }

    private static OrderItem entity2OrderItem(OrderItemEntity orderItemEntity) {
        if (null == orderItemEntity) {
            return null;
        }
        OrderItem orderItem = new OrderItem();
        orderItem.setId(orderItemEntity.getId());
        orderItem.setPrice(orderItemEntity.getPrice());
        orderItem.setAmount(orderItemEntity.getAmount());
        // TODO
        // orderItem.setProduct();
        return orderItem;
    }
}
