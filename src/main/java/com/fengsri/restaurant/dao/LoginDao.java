package com.fengsri.restaurant.dao;

import com.fengsri.restaurant.entity.User;

public interface LoginDao {
    /*用户名和密码登陆*/
    public User login(User user);

}
