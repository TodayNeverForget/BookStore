package com.yp.test;

import com.yp.pojo.User;
import com.yp.service.UserService;
import com.yp.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceImplTest {
    UserServiceImpl userService = new UserServiceImpl();

    @Test
    public void login() {

        System.out.println(userService.login(new User(null, "yangpeng", "123456", null)));
    }

    @Test
    public void regist() {
        userService.regist(new User(null, "yangpeng", "123456", "kk@qq.com"));
    }

    @Test
    public void exitUserName() {
        if (userService.exitUserName("yangpeng")) {
            System.out.println("不可用");
        } else {
            System.out.println("可用");
        }
    }
}














