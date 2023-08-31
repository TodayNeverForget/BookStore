package com.yp.test;

import com.yp.dao.impl.OrderItemDAOImpl;
import com.yp.pojo.Order;
import com.yp.pojo.OrderItem;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.*;

public class OrderItemDAOImplTest {
    OrderItemDAOImpl orderItemDAO = new OrderItemDAOImpl();

    @Test
    public void saveOrderItem() {

        System.out.println(orderItemDAO.saveOrderItem(
                new OrderItem(null, "西游记", 3, new BigDecimal(12), new BigDecimal(36), "1")));
        System.out.println(orderItemDAO.saveOrderItem(
                new OrderItem(null, "水浒传", 1, new BigDecimal(33.05), new BigDecimal(33.05), "1")));

    }
}