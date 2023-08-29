package com.yp.web;

import com.yp.pojo.User;
import com.yp.service.impl.UserServiceImpl;
import com.yp.utils.WebUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.lang.reflect.Method;

public class UserServlet extends BaseServlet {
    private UserServiceImpl userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    /*@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String action = request.getParameter("action");

        try {
            Method method = this.getClass().getDeclaredMethod(action,
                    HttpServletRequest.class, HttpServletResponse.class);

            method.invoke(this, request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }


        *//*if ("login".equals(request.getParameter("action"))) {
            login(userService, request, response);
        } else if ( "regist".equals(request.getParameter("action"))) {
            regist(userService, request, response);
        }*//*
    }*/

    void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (userService.login(new User(null, username, password, null)) != null) {
            System.out.println("登录成功");
            request.getRequestDispatcher("/pages/user/login_success.jsp")
                    .forward(request, response);

        } else {
            System.out.println("用户名名密码错误");
            request.setAttribute("msg", "用户名或密码错误");
            request.setAttribute("username", username);
            request.getRequestDispatcher("/pages/user/login.jsp")
                    .forward(request, response);
        }

    }

    void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String code = request.getParameter("code");

        User user = WebUtils.copyParamToBean(request.getParameterMap(), new User());
        System.out.println(user);

        if ("bnbnp".equalsIgnoreCase(code)) {

            if (!userService.exitUserName(username)) {
                System.out.println("注册成功");
                userService.regist(new User(null, username, password, email));
                request.getRequestDispatcher("/pages/user/regist_success.jsp")
                        .forward(request, response);

            } else {

                System.out.println("用户名已存在");

                request.setAttribute("msg", "用户名已存在");
                request.setAttribute("username", username);
                request.setAttribute("email", email);
                request.setAttribute("password", password);

                request.getRequestDispatcher("/pages/user/regist.jsp")
                        .forward(request, response);
            }
        } else {
            System.out.println("验证码有误");

            request.setAttribute("msg", "验证码有误");
            request.setAttribute("username", username);
            request.setAttribute("email", email);

            request.getRequestDispatcher("/pages/user/regist.jsp")
                    .forward(request, response);
        }

    }


}
