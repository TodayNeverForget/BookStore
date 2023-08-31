package com.yp.service;

import com.yp.dao.OrderItemDAO;
import com.yp.dao.impl.OrderItemDAOImpl;
import com.yp.pojo.OrderItem;

import java.util.List;

public interface OrderItemService {

    public int saveOrderItem(OrderItem orderItem, String orderId);

    public List<OrderItem> queryOrderItemsByOrderId(String orderId);


}
