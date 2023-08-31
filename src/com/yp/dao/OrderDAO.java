package com.yp.dao;

import com.yp.pojo.Order;

import java.util.List;

public interface OrderDAO {

    public int saveOrder(Order order);

    public List<Order> queryOrders();

    public int changeOrderStatus(String orderId, int status);

    public List<Order> queryOrdersByUserId(Integer userId);

}
