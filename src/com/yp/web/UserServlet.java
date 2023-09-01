package com.yp.web;

import com.google.gson.Gson;
import com.yp.pojo.User;
import com.yp.service.impl.UserServiceImpl;
import com.yp.utils.WebUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

public class UserServlet extends BaseServlet {
    private UserServiceImpl userService = new UserServiceImpl();


    void logOut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getSession().invalidate();
        System.out.println("注销成功");

        response.sendRedirect(request.getContextPath());
    }


    void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User loginUser = userService.login(new User(null, username, password, null));
        if (loginUser != null) {
            System.out.println("登录成功");

            request.getSession().setAttribute("user", loginUser);
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
        String kaptcha = (String) request.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        request.getSession().removeAttribute(KAPTCHA_SESSION_KEY);


        User user = WebUtils.copyParamToBean(request.getParameterMap(), new User());
        System.out.println(user);

        if (kaptcha != null &&  kaptcha.equalsIgnoreCase(code)) {

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


    protected void ajaxExitsUserName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");

        boolean exitUserName = userService.exitUserName(username);

        Map<String, Boolean> stringBooleanMap = new HashMap<>();

        stringBooleanMap.put("exitUserName", exitUserName);

        Gson gson = new Gson();

        String s = gson.toJson(stringBooleanMap);

        response.getWriter().write(s);

    }


}
