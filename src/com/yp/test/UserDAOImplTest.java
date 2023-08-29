package com.yp.test;

import com.yp.dao.impl.UserDAOImpl;
import com.yp.pojo.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDAOImplTest {

    @Test
    public void queryUserByUserName() {
        UserDAOImpl userDAO = new UserDAOImpl();
        System.out.println(userDAO.queryUserByUserName("admin"));
    }

    @Test
    public void queryUserByUserNameAndPassWord() {
        UserDAOImpl userDAO = new UserDAOImpl();
        System.out.println(userDAO.queryUserByUserNameAndPassWord("admin", "admin"));
    }

    @Test
    public void saveUser() {
        UserDAOImpl userDAO = new UserDAOImpl();
        User user = new User(null, "jack", "123456", "145@qq.com");
        System.out.println(userDAO.saveUser(user));
    }
}







