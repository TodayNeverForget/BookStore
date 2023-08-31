package com.yp.service.impl;

import com.yp.dao.OrderItemDAO;
import com.yp.dao.impl.OrderItemDAOImpl;
import com.yp.pojo.OrderItem;
import com.yp.service.OrderItemService;

import java.util.List;

public class OrderItemServiceImpl implements OrderItemService {
    OrderItemDAO orderItemDAO = new OrderItemDAOImpl();

    @Override
    public int saveOrderItem(OrderItem orderItem, String orderId) {
        return 0;
    }

    @Override
    public List<OrderItem> queryOrderItemsByOrderId(String orderId) {
        return orderItemDAO.queryOrderItemsByOrderId(orderId);
    }

}









