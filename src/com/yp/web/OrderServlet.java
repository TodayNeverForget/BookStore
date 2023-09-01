package com.yp.web;

import com.yp.pojo.Cart;
import com.yp.pojo.Order;
import com.yp.pojo.OrderItem;
import com.yp.pojo.User;
import com.yp.service.OrderItemService;
import com.yp.service.OrderService;
import com.yp.service.impl.OrderItemServiceImpl;
import com.yp.service.impl.OrderServiceImpl;
import com.yp.utils.JdbcUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class OrderServlet extends BaseServlet {
    OrderService orderService = new OrderServiceImpl();
    OrderItemService orderItemService = new OrderItemServiceImpl();

    protected void createOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        User loginUser = (User) session.getAttribute("user");
        if (loginUser == null) {
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
            return;
        }
        Integer userId = loginUser.getId();

        String orderId = null;

        orderId = orderService.createOrder(cart, userId);

        session.setAttribute("orderId", orderId);

        System.out.println("订单创建成功");

        response.sendRedirect(request.getContextPath() + "/pages/cart/checkout.jsp");
    }

    protected void myOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User loginUser = (User) session.getAttribute("user");

        if (loginUser == null) {
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
            return;
        }

        Integer userId = loginUser.getId();

        List<Order> myOrders = orderService.queryOrdersByUserId(userId);
        request.setAttribute("myOrders", myOrders);

        request.getRequestDispatcher("/pages/order/order.jsp").forward(request, response);
    }

    protected void orderDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String orderId = request.getParameter("orderId");

        List<OrderItem> orderItems = orderItemService.queryOrderItemsByOrderId(orderId);

        request.setAttribute("orderItems", orderItems);

        request.getRequestDispatcher("/pages/order/order_detail.jsp").forward(request, response);
    }

    protected void allOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



    }

    protected void send(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



    }

    protected void receive(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



    }


}
