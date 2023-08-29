package com.yp.web;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.lang.reflect.Method;

public class BaseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String action = request.getParameter("action");

        System.out.println("base我来过");

        try {
            Method method = this.getClass().getDeclaredMethod(action,
                    HttpServletRequest.class, HttpServletResponse.class);

            method.invoke(this, request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
