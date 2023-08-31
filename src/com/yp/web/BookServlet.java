package com.yp.web;

import com.yp.pojo.Book;
import com.yp.pojo.Page;
import com.yp.service.BookService;
import com.yp.service.impl.BookServiceImpl;
import com.yp.service.impl.UserServiceImpl;
import com.yp.utils.WebUtils;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class BookServlet extends BaseServlet {
    private BookService bookService = new BookServiceImpl();



    protected void add(HttpServletRequest request
            , HttpServletResponse response) throws ServletException, IOException {

        System.out.println("添加图书");

        Book book = WebUtils.copyParamToBean(request.getParameterMap(), new Book());
        bookService.addBook(book);
        int pageNo = (WebUtils.parseInt(request.getParameter("pageNo"), 0) + 1);

//        System.out.println(request.getContextPath());
//        System.out.println(request.getRequestDispatcher("/manager/bookServlet"));
        //为什么这里的/不能被浏览器解析到端口号？？？
        /*由于不知为什么浏览器无法解析传回的
        request.getContextPath()为服务器地址到端口号
        只解析了工程名，前面的端口号服务器ip都没有*//*
        String basePath = request.getScheme() +
                "://" + request.getServerName() + ":" +
                request.getServerPort() + "/" + request.getContextPath();
        System.out.println(request.getContextPath());*/
        response.sendRedirect(request.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + pageNo);
    }

    protected void delete(HttpServletRequest request
            , HttpServletResponse response) throws ServletException, IOException {
        int pageNo = (WebUtils.parseInt(request.getParameter("pageNo"), 0) + 1);
        bookService.deletBook(WebUtils.parseInt(request.getParameter("id"), 0));
        System.out.println("已删除");/*
        *//*由于不知为什么浏览器无法解析传回的
        request.getContextPath()为服务器地址到端口号
        只解析了工程名，前面的端口号服务器ip都没有*//*
        String basePath = request.getScheme() +
                "://" + request.getServerName() + ":" +
                request.getServerPort() + "/" + request.getContextPath();*/
//        response.sendRedirect(request.getHeader("Referer"));
        response.sendRedirect(request.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + pageNo);
    }

    protected void update(HttpServletRequest request
            , HttpServletResponse response) throws ServletException, IOException {
        int pageNo = (WebUtils.parseInt(request.getParameter("pageNo"), 0) + 1);

        Book book = WebUtils.copyParamToBean(request.getParameterMap(), new Book());
        bookService.updateBook(book);
        System.out.println("更新成功");

        /*由于不知为什么浏览器无法解析传回的
        request.getContextPath()为服务器地址到端口号
        只解析了工程名，前面的端口号服务器ip都没有*//*
        String basePath = request.getScheme() +
                "://" + request.getServerName() + ":" +
                request.getServerPort() + "/" + request.getContextPath();*/
        response.sendRedirect(request.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + pageNo);
    }

    protected void list(HttpServletRequest request
            , HttpServletResponse response) throws ServletException, IOException {

        System.out.println("我来看书了list");
        List<Book> books = bookService.queryBooks();

        request.setAttribute("books", books);

        request.getRequestDispatcher("/pages/manager/book_manager.jsp")
                .forward(request, response);

    }

    protected void getBook(HttpServletRequest request
            , HttpServletResponse response) throws ServletException, IOException {

        System.out.println("我来查单本书");
        Book book = bookService.queryBookById(WebUtils.parseInt(request.getParameter("id"), 0));

        request.setAttribute("book", book);

        request.getRequestDispatcher("/pages/manager/book_edit.jsp?method=update")
                .forward(request, response);

    }

    protected void page(HttpServletRequest request
            , HttpServletResponse response) throws ServletException, IOException {


        int pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);

        Page<Book> page = bookService.page(pageNo, pageSize);

        page.setUrl("manager/bookServlet?action=page");
        request.setAttribute("page", page);

        request.getRequestDispatcher("/pages/manager/book_manager.jsp")
                .forward(request, response);

    }



}
