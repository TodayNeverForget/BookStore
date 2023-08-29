package com.yp.dao.impl;

import com.yp.dao.BookDAO;
import com.yp.pojo.Book;

import java.util.List;

public class BookDAOImpl extends BaseDAO implements BookDAO {
    @Override
    public List<Book> queryBooks() {
        String sql = "select * from t_book";

        return queryMulti(Book.class, sql);
    }

    @Override
    public Book queryBookById(Integer id) {
        String sql = "select * from t_book where id = ?";

        return queryOne(Book.class, sql, id);
    }

    @Override
    public int addBook(Book book) {
        String sql = "insert into t_book values(null, ?, ?, ?, ?, ?, ?)";

        return update(sql, book.getName(), book.getPrice(), book.getAuthor()
                , book.getSales(), book.getStock(), book.getImgPath());
    }

    @Override
    public int deletBookById(Integer id) {
        String sql = "delete from t_book where id = ?";

        return update(sql, id);
    }

    @Override
    public int updateBook(Book book) {
        String sql = "update t_book set `name` = ? , `author` = ? " +
                ", `price` = ? , `sales` = ? , `stock` = ? , `img_path` = ? where id = ?";

        return update(sql, book.getName(), book.getAuthor(), book.getPrice()
                , book.getSales(), book.getStock(), book.getImgPath(), book.getId());
    }

    @Override
    public List<Book> queryPageItems(Integer begin, Integer pageSize) {
        String sql = "select id, name, author, price, sales, stock, img_path imgPath " +
                "from t_book limit ?, ?";

        return queryMulti(Book.class, sql, begin, pageSize);
    }

    @Override
    public int queryPageTotalCount() {
        String sql = "select count(*) from t_book";
        Number totalCount = (Number) queryScar(sql);

        return totalCount.intValue();
    }


}













