package com.fengsri.restaurant.service.impl;

import com.fengsri.restaurant.dao.RegisterDao;
import com.fengsri.restaurant.entity.User;
import com.fengsri.restaurant.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author fengwen
 * @date 2019/4/8 11:32
 */
@Service
public class RegisterServiceImpl  implements RegisterService {

    @Autowired
    private RegisterDao dao;


    /*注册用户*/
    public int register(User user){
        return dao.register(user);
    }

}
