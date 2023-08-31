package com.yp.test;

import com.yp.service.OrderItemService;
import com.yp.service.impl.OrderItemServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class OrderItemServiceImplTest {
    OrderItemService orderItemService = new OrderItemServiceImpl();

    @Test
    public void queryOrderItemsByOrderId() {

        System.out.println(orderItemService.queryOrderItemsByOrderId("1"));

    }
}