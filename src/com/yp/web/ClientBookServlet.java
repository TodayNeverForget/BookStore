package com.yp.web;

import com.yp.pojo.Book;
import com.yp.pojo.Page;
import com.yp.service.BookService;
import com.yp.service.impl.BookServiceImpl;
import com.yp.utils.WebUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.math.BigDecimal;

public class ClientBookServlet extends BaseServlet {
    private BookService bookService = new BookServiceImpl();


    protected void page(HttpServletRequest request
            , HttpServletResponse response) throws ServletException, IOException {

        int pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);

        Page<Book> page = bookService.page(pageNo, pageSize);

        page.setUrl("client/clientBookServlet?action=page");
        request.setAttribute("page", page);

        request.getRequestDispatcher("/pages/client/index.jsp")
                .forward(request, response);

    }

    protected void pageByPrice(HttpServletRequest request
            , HttpServletResponse response) throws ServletException, IOException {/*
        if ((request.getParameter("min") == null || request.getParameter("min").equals("")) &&
                (request.getParameter("max") == null || request.getParameter("max").equals(""))) {
            request.getRequestDispatcher("client/clientBookServlet?action=page")
                    .forward(request, response);
        }*/

        int min = WebUtils.parseInt(request.getParameter("min"), 0);
        int max = WebUtils.parseInt(request.getParameter("max"), Integer.MAX_VALUE);
        int pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);

        Page<Book> page = bookService.pageByPrice(pageNo, pageSize, min, max);

        StringBuilder sb = new StringBuilder("client/clientBookServlet?action=pageByPrice");

        if (request.getParameter("min") != null) {
            sb.append("&min=").append(request.getParameter("min"));
        }
        if (request.getParameter("max") != null) {
            sb.append("&max=").append(request.getParameter("max"));
        }

        page.setUrl(sb.toString());
        request.setAttribute("page", page);

        request.getRequestDispatcher("/pages/client/index.jsp")
                .forward(request, response);

    }


}
