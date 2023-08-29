package com.yp.service;

import com.yp.pojo.Book;
import com.yp.pojo.Page;

import java.math.BigDecimal;
import java.util.List;

public interface BookService {

    public void addBook(Book book);

    public void updateBook(Book book);

    public void deletBook(Integer id);

    public Book queryBookById(Integer id);

    public List<Book> queryBooks();

    public Page<Book> page(Integer pageNo, Integer pageSize);

    Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max);
}
