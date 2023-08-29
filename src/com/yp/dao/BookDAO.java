package com.yp.dao;

import com.yp.pojo.Book;
import com.yp.pojo.User;

import java.math.BigDecimal;
import java.util.List;

public interface BookDAO {

    public List<Book> queryBooks();

    public Book queryBookById(Integer id);

    public int addBook(Book book);

    public int deletBookById(Integer id);

    public int updateBook(Book book);

    public List<Book> queryPageItems(Integer begin, Integer pageSize);

    public int queryPageTotalCount();


    List<Book> queryPageItemsByPrice(int begin, int pageSize, int min, int max);

    public int queryPageTotalCountByPrice(int min, int max);
}












