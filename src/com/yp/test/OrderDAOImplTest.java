package com.yp.test;

import com.yp.dao.OrderDAO;
import com.yp.dao.OrderItemDAO;
import com.yp.dao.impl.OrderDAOImpl;
import com.yp.dao.impl.OrderItemDAOImpl;
import com.yp.pojo.Order;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.*;

public class OrderDAOImplTest {
    OrderDAO orderDAO = new OrderDAOImpl();

    @Test
    public void saveOrder() {

        System.out.println(orderDAO.saveOrder(
                new Order("1", new Date(), new BigDecimal(88), 0, 1)));

    }
}