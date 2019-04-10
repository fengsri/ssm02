package com.fengsri.restaurant.controller;

import com.fengsri.restaurant.entity.User;
import com.fengsri.restaurant.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author fengwen
 * @date 2019/4/8 11:12
 */
@Controller
@RequestMapping(value = "/register")
public class RegisterController {

    @Autowired
    private RegisterService service;

    //到注册页面
    @RequestMapping(value = "/to_register")
    public String toRegister(){
        return "register";
    }

    //注册用户信息
    @RequestMapping(value = "/user_register",method = RequestMethod.POST)
    public String register(User user){
        int i = service.register(user);
        if(i!=0){  //注册成功跳转到登陆界面
            return "login";
        }else{  //注册失败跳转到注册页面
            return "register";
        }
    }


}
