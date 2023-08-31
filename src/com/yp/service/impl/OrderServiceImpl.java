package com.yp.service.impl;

import com.yp.dao.BookDAO;
import com.yp.dao.OrderDAO;
import com.yp.dao.OrderItemDAO;
import com.yp.dao.impl.BookDAOImpl;
import com.yp.dao.impl.OrderDAOImpl;
import com.yp.dao.impl.OrderItemDAOImpl;
import com.yp.pojo.*;
import com.yp.service.OrderService;

import java.math.BigDecimal;
import java.util.*;

public class OrderServiceImpl implements OrderService {
    OrderDAO orderDAO = new OrderDAOImpl();
    OrderItemDAO orderItemDAO = new OrderItemDAOImpl();
    BookDAO bookDAO = new BookDAOImpl();


    @Override
    public String createOrder(Cart cart, Integer userId) {

        String orderId = System.currentTimeMillis() + "" + userId;

        Order order = new Order(orderId, new Date(), cart.getTotalPrice(), 0, userId);

        orderDAO.saveOrder(order);

        Collection<CartItem> cartItems = cart.getItems().values();

        for (CartItem cartItem : cartItems) {
            orderItemDAO.saveOrderItem(
                    new OrderItem(null, cartItem.getName(), cartItem.getCount()
                            , cartItem.getPrice(), cartItem.getTotalPrice(), orderId));

            Book book = bookDAO.queryBookById(cartItem.getId());
            book.setSales(book.getSales() + cartItem.getCount());
            book.setStock(book.getStock() - cartItem.getCount());
            bookDAO.updateBook(book);
        }



        cart.clear();

        return orderId;
    }

    @Override
    public List<Order> queryOrdersByUserId(Integer userId) {
        return orderDAO.queryOrdersByUserId(userId);
    }

    @Override
    public List<Order> queryOrders() {
        return null;
    }

    @Override
    public void changeOrderStatus(String orderId) {

    }
}















