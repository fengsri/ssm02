package com.fengsri.restaurant.controller;

import com.fengsri.restaurant.entity.User;
import com.fengsri.restaurant.service.UserService;
import com.fengsri.restaurant.util.MenuPagerUtil;
import com.fengsri.restaurant.vo.MenuShow;
import com.fengsri.restaurant.vo.Pager;
import com.fengsri.restaurant.vo.UserShow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author fengwen
 * @date 2019/4/9 10:53
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;


    //到用户管理页面
    @RequestMapping(value = "/manager_user")
    public String toManagerUser(Model model){
        int all_pager = userService.getAllPager();  //当前的总的商品页数
        Pager pager = MenuPagerUtil.getMenuPager(1,all_pager);
        List<UserShow> userShows = userService.findByPager(pager);
        model.addAttribute("userShows",userShows);  //设置查询出来的数据
        model.addAttribute("pager", pager);  //设置分页显示数据
        return "user_manager";
    }


    //分页查询用户
    @RequestMapping(value = "/pager")
    public String pagerSearch(Pager pager, Model model){
        List<UserShow>  userShows= userService.findByPager(pager);
        model.addAttribute("userShows",userShows);  //设置查询出来的数据
        model.addAttribute("pager", pager);  //设置分页显示数据
        return "user_manager";
    }

    //通过用户输入的用户名进行模糊查询
    @RequestMapping(value = "/user_like",method = RequestMethod.POST)
    public String searchMenu(String user_like, Model model){
        List<UserShow> userShows = userService.searchUser(user_like);
        model.addAttribute("userShows",userShows);
        return "user_search";
    }

    //到修改用户信息页面
    @RequestMapping(value = "/to_modify")
    public String toModify(Integer user_id,Model model){
        UserShow userShow = userService.findById(user_id);
        model.addAttribute("userShow",userShow);
        return "user_modify";
    }

    //修改用户基本信息
    @RequestMapping(value = "/modify")
    public String modify(UserShow us,Model model){
        int i = userService.modify(us);
        if(i!=0){  //修改成功
            UserShow userShow = userService.findById(us.getUser_id());
            model.addAttribute("userShow",userShow);
            return "user_modify";
        }else{ //修改失败
            model.addAttribute("message","修改失败");
            return "error";
        }
    }


    /*删除用户信息,用user_id为标识*/
    @RequestMapping(value = "/delete")
    public String delete(Integer user_id,Model model){
        int i = userService.delete(user_id);
        if(i!=0){  //删除成功
            int all_pager = userService.getAllPager();  //当前的总的商品页数
            Pager pager = MenuPagerUtil.getMenuPager(1,all_pager);
            List<UserShow> userShows = userService.findByPager(pager);
            model.addAttribute("userShows",userShows);  //设置查询出来的数据
            model.addAttribute("pager", pager);  //设置分页显示数据
            return "user_manager";
        }else{ //删除失败
            model.addAttribute("message","删除失败");
            return "error";
        }
    }

    /*到添加用户界面*/
    @RequestMapping(value = "/to_add")
    public String toAdd(){
        return "user_add";
    }

    /*添加用户*/
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String add(UserShow userShow,Model model){
        int i = userService.add(userShow);
        if(i!=0){
            int all_pager = userService.getAllPager();  //当前的总的商品页数
            Pager pager = MenuPagerUtil.getMenuPager(1,all_pager);
            List<UserShow> userShows = userService.findByPager(pager);
            model.addAttribute("userShows",userShows);  //设置查询出来的数据
            model.addAttribute("pager", pager);  //设置分页显示数据
            return "user_manager";
        }else{
            model.addAttribute("message","添加失败");
            return "error";
        }
    }


}
