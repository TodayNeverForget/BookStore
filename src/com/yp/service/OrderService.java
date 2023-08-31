package com.yp.service;

import com.yp.dao.OrderDAO;
import com.yp.dao.impl.OrderDAOImpl;
import com.yp.pojo.Cart;
import com.yp.pojo.Order;

import java.util.List;

public interface OrderService {

    public String createOrder(Cart cart, Integer userId);

    public List<Order> queryOrdersByUserId(Integer userId);

    public List<Order> queryOrders();

    public void changeOrderStatus(String orderId);



}













