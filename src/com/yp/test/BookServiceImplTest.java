package com.yp.test;

import com.yp.pojo.Book;
import com.yp.pojo.Page;
import com.yp.service.BookService;
import com.yp.service.impl.BookServiceImpl;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class BookServiceImplTest {
    BookService bookService = new BookServiceImpl();

    @Test
    public void addBook() {
    }

    @Test
    public void updateBook() {
    }

    @Test
    public void deleteBook() {
    }

    @Test
    public void queryBookById() {
        System.out.println(bookService.queryBooks());
    }

    @Test
    public void queryBooks() {
    }

    @Test
    public void page() {
        System.out.println(bookService.page(2, 4));
    }
}










