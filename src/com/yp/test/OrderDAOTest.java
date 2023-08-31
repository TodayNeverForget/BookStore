package com.yp.test;

import com.yp.dao.OrderDAO;
import com.yp.dao.impl.OrderDAOImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class OrderDAOTest {
    OrderDAO orderDAO = new OrderDAOImpl();

    @Test
    public void queryOrdersByUserId() {

        System.out.println(orderDAO.queryOrdersByUserId(1));
    }
}