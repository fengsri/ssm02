package com.fengsri.restaurant.controller;

import com.fengsri.restaurant.entity.User;
import com.fengsri.restaurant.service.LoginService;
import com.fengsri.restaurant.service.MenuService;
import com.fengsri.restaurant.util.MenuPagerUtil;
import com.fengsri.restaurant.vo.Pager;
import com.fengsri.restaurant.vo.MenuShow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author fengwen
 * @date 2019/4/8 14:16
 */
@Controller
@RequestMapping(value = "/login")
public class LoginCotroller {

    @Autowired
    private LoginService service;  //用于登陆

    @Autowired
    private MenuService menuService ; //用于查询商品


    @RequestMapping(value = "/to_login")
    public String toLogin(){
        return "/login";
    }


    //用户名和密码进行登陆
    @RequestMapping(value = "/user_login",method = RequestMethod.POST)
    public String login(User u, Model model, HttpServletRequest request){
        User user = service.login(u);
        if(user!=null){  //登陆成功
            request.getSession().setAttribute("user",user);//用session进行保存用户信息
            int all_pager = menuService.getAllPager();  //当前的总的商品页数
            Pager pager = MenuPagerUtil.getMenuPager(1,all_pager);
            List<MenuShow> menuShows = menuService.findByPager(pager);
            model.addAttribute("menuShows",menuShows);  //设置查询出来的数据
            model.addAttribute("pager", pager);  //设置分页显示数据
            return "index";
        }else{   //登陆失败
            return "login";
        }
    }



}
