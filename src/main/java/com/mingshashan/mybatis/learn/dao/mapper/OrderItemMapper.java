package com.mingshashan.mybatis.learn.dao.mapper;

import com.mingshashan.mybatis.learn.entity.OrderItemEntity;

import java.util.List;

/**
 *
 */
public interface OrderItemMapper {

    /**
     * save
     *
     * @param orderItemEntity
     * @return
     */
    Integer saveOrderItem(OrderItemEntity orderItemEntity);

    /**
     * batch save
     *
     * @param orderItemEntityList
     * @return
     */
    Integer batchSaveOrderItemList(List<OrderItemEntity> orderItemEntityList);

    /**
     * get by id
     *
     * @param id
     * @return
     */
    OrderItemEntity getById(String id);

    /**
     * get by order id
     *
     * @param orderId
     * @return
     */
    OrderItemEntity getByOrderId(String orderId);

    /**
     * delete by order id
     *
     * @param orderId
     * @return
     */
    Integer deleteByOrderId(String orderId);
}
