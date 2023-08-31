package com.yp.web;

import com.yp.pojo.Book;
import com.yp.pojo.Cart;
import com.yp.pojo.CartItem;
import com.yp.service.BookService;
import com.yp.service.impl.BookServiceImpl;
import com.yp.utils.WebUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.math.BigDecimal;

public class CartServlet extends BaseServlet {
    BookService bookService = new BookServiceImpl();

    protected void addItem(HttpServletRequest request
            , HttpServletResponse response) throws ServletException, IOException {

        Integer id = WebUtils.parseInt(request.getParameter("id"), 0);

        Book book = bookService.queryBookById(id);
        CartItem item = new CartItem(book.getId(), book.getName(), 1, book.getPrice(), book.getPrice());
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");

        if (cart == null) {
            cart = new Cart();
            session.setAttribute("cart", cart);
        }

        session.setAttribute("lastAdd", book.getName());
        cart.addItem(item);
        response.sendRedirect(request.getHeader("Referer"));
    }

    protected void deleteItem(HttpServletRequest request
            , HttpServletResponse response) throws ServletException, IOException {

        Integer id = WebUtils.parseInt(request.getParameter("id"), 0);

        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");

        if (cart != null) {
            cart.deleteItem(id);
        }
        response.sendRedirect(request.getHeader("Referer"));

    }

    protected void clear(HttpServletRequest request
            , HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");

        if (cart != null) {
            cart.clear();
        }
        response.sendRedirect(request.getHeader("Referer"));

    }

    protected void updateItem(HttpServletRequest request
            , HttpServletResponse response) throws ServletException, IOException {
        Integer id = WebUtils.parseInt(request.getParameter("id"), 0);
        Integer count = WebUtils.parseInt(request.getParameter("count"), 0);

        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");

        cart.updateItem(id, count);
        response.sendRedirect(request.getHeader("Referer"));
    }





}
