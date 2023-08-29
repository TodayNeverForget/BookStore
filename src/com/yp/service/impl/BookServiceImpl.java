package com.yp.service.impl;

import com.yp.dao.BookDAO;
import com.yp.dao.impl.BookDAOImpl;
import com.yp.pojo.Book;
import com.yp.pojo.Page;
import com.yp.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {
    BookDAO bookDAO = new BookDAOImpl();

    @Override
    public void addBook(Book book) {
        bookDAO.addBook(book);
    }

    @Override
    public void updateBook(Book book) {
        bookDAO.updateBook(book);
    }

    @Override
    public void deletBook(Integer id) {
        bookDAO.deletBookById(id);
    }

    @Override
    public Book queryBookById(Integer id) {
        return bookDAO.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDAO.queryBooks();
    }

    @Override
    public Page<Book> page(Integer pageNo, Integer pageSize) {
        Page<Book> page = new Page<>();
        //页大小
        page.setPageSize(pageSize);

        int pageTotalCount = bookDAO.queryPageTotalCount();
        //数据总数
        page.setPageTotalCount(pageTotalCount);

        int pageTotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize != 0) {
            pageTotal++;
        }
        //页总数
        page.setPageTotal(pageTotal);
        //页码



        page.setPageNo(pageNo);
        int begin = (page.getPageNo() - 1) * pageSize;
        List<Book> items = bookDAO.queryPageItems(begin, pageSize);

        //当前页数据
        page.setItems(items);

        return page;
    }

}
