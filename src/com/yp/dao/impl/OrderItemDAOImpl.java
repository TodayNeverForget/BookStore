package com.yp.dao.impl;

import com.yp.dao.OrderItemDAO;
import com.yp.pojo.OrderItem;

import java.util.List;

public class OrderItemDAOImpl extends BaseDAO implements OrderItemDAO {
    @Override
    public int saveOrderItem(OrderItem orderItem) {
        String sql = "insert into t_order_item (name, count, price, total_price, order_id) values(?, ?, ?, ?, ?)";

        return update(sql, orderItem.getName(), orderItem.getCount()
                , orderItem.getPrice(), orderItem.getTotalPrice(), orderItem.getOrderId());
    }

    @Override
    public List<OrderItem> queryOrderItemsByOrderId(String orderId) {
        String sql = "select id, name, count, price, total_price totalPrice" +
                ", order_id orderId from t_order_item where order_id = ?";

        return queryMulti(OrderItem.class, sql, orderId);
    }
}












