package com.yp.service;

import com.yp.pojo.User;

public interface UserService {

    public User login(User user);

    public void regist(User user);

    public boolean exitUserName(String username);

}
