package com.yp.dao;

import com.yp.pojo.OrderItem;

import java.util.List;

public interface OrderItemDAO {

    public int saveOrderItem(OrderItem orderItem);

    public List<OrderItem> queryOrderItemsByOrderId(String orderId);

}
