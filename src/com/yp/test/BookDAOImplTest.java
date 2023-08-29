package com.yp.test;

import com.yp.dao.BookDAO;
import com.yp.dao.impl.BookDAOImpl;
import com.yp.pojo.Book;
import com.yp.pojo.Page;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class BookDAOImplTest {
    private BookDAO bookDAO = new BookDAOImpl();

    @Test
    public void queryBook() {
        System.out.println(bookDAO.queryBooks());
    }

    @Test
    public void queryBookById() {
        System.out.println(bookDAO.queryBookById(22));
    }

    @Test
    public void addBook() {
        Book book = new Book(null, "有名", "li"
                , new BigDecimal(99), 44, 34, null);
        System.out.println(bookDAO.addBook(book));
    }

    @Test
    public void deletBookById() {
        System.out.println(bookDAO.deletBookById(21));
    }

    @Test
    public void updataBook() {

        System.out.println(bookDAO.updateBook(new Book(21, "无名"
                , "杨鹏", new BigDecimal(33), 88, 99, null)));
    }

    @Test
    public void queryPageItems() {
        System.out.println(bookDAO.queryPageItems(4, Page.PAGE_SIZE));
    }

    @Test
    public void queryPageTotalCount() {
        System.out.println(bookDAO.queryPageTotalCount());
    }

}












