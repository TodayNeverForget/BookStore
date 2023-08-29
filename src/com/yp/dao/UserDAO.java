package com.yp.dao;

import com.yp.pojo.User;

public interface UserDAO {

    public User queryUserByUserName(String username);

    public User queryUserByUserNameAndPassWord(String username, String password);

    public int saveUser(User user);

}
