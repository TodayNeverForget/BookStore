package com.yp.test;

import com.yp.pojo.Cart;
import com.yp.pojo.CartItem;
import com.yp.service.OrderService;
import com.yp.service.impl.OrderServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class OrderServiceTest {
    Cart cart = new Cart();
    OrderService orderService = new OrderServiceImpl();

    @Test
    public void createOrder() {

        cart.addItem(new CartItem(1, "水流行", 1, new BigDecimal(12), new BigDecimal(12)));
        cart.addItem(new CartItem(1, "水流行", 1, new BigDecimal(12), new BigDecimal(12)));
        cart.addItem(new CartItem(2, "哈哈", 1, new BigDecimal(223), new BigDecimal(223)));

        orderService.createOrder(cart, 1);

    }
}