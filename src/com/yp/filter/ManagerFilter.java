package com.yp.filter;

import com.yp.pojo.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ManagerFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

        HttpSession session = httpServletRequest.getSession();

        User loginUser = (User) session.getAttribute("user");

        if (loginUser == null) {
            servletRequest.getRequestDispatcher("/pages/user/login.jsp").forward(servletRequest,servletResponse);
            return;
        } else if (!loginUser.getUsername().equals("admin")) {
            System.out.println("非管理员禁止访问");
            servletRequest.getRequestDispatcher("/").forward(servletRequest,servletResponse);
            return;
        }

        filterChain.doFilter(servletRequest, servletResponse);

        System.out.println("返回通道");
    }

    @Override
    public void destroy() {

    }
}








