package com.yp.service.impl;

import com.yp.dao.impl.UserDAOImpl;
import com.yp.pojo.User;
import com.yp.service.UserService;

public class UserServiceImpl implements UserService {
    UserDAOImpl userDAO = new UserDAOImpl();

    @Override
    public User login(User user) {
        return userDAO.queryUserByUserNameAndPassWord(user.getUsername(), user.getPassword());
    }

    @Override
    public void regist(User user) {
        userDAO.saveUser(user);
    }

    @Override
    public boolean exitUserName(String username) {
        if (userDAO.queryUserByUserName(username) == null) {
            return false;
        }

        return true;
    }
}















