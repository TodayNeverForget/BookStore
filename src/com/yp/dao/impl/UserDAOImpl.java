package com.yp.dao.impl;

import com.yp.dao.UserDAO;
import com.yp.pojo.User;

public class UserDAOImpl extends BaseDAO implements UserDAO {


    @Override
    public User queryUserByUserName(String username) {
        String sql = "select * from t_user where username = ?";
        return queryOne(User.class, sql, username);
    }

    @Override
    public User queryUserByUserNameAndPassWord(String username, String password) {
        String sql = "select * from t_user where username = ? and password = ?";
        return queryOne(User.class, sql, username, password);
    }

    @Override
    public int saveUser(User user) {
        String sql = "insert into t_user values(null, ?, ?, ?)";
        return update(sql, user.getUsername(), user.getPassword(), user.getEmail());
    }
}










