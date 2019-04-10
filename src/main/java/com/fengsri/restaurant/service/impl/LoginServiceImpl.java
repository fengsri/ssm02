package com.fengsri.restaurant.service.impl;

import com.fengsri.restaurant.dao.LoginDao;
import com.fengsri.restaurant.entity.User;
import com.fengsri.restaurant.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author fengwen
 * @date 2019/4/8 14:14
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginDao dao;

    /*用户名和密码登陆*/
    public User login(User user){
        return dao.login(user);
    }
}
