package com.fengsri.restaurant.controller;

import com.fengsri.restaurant.dao.MenuDao;
import com.fengsri.restaurant.service.MenuService;
import com.fengsri.restaurant.util.MenuPagerUtil;
import com.fengsri.restaurant.vo.Pager;
import com.fengsri.restaurant.vo.MenuShow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author fengwen
 * @date 2019/4/8 19:59
 */
@Controller
@RequestMapping(value = "/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    //通过用户输入的商品名进行模糊查询
    @RequestMapping(value = "/menu_like",method = RequestMethod.POST)
    public String searchMenu(String menu_like, Model model){
        List<MenuShow>  menuShows= menuService.searchMenu(menu_like);
        model.addAttribute("menuShows",menuShows);
        return "search";
    }


    //返回到首页
    @RequestMapping(value = "/to_index")
    public String backToIndex(Model model){
        int all_pager = menuService.getAllPager();  //当前的总的商品页数
        Pager pager = MenuPagerUtil.getMenuPager(1,all_pager);
        List<MenuShow> menuShows = menuService.findByPager(pager);
        model.addAttribute("menuShows",menuShows);  //设置查询出来的数据
        model.addAttribute("pager", pager);  //设置分页显示数据
        return "index";
    }

    //分页查询
    @RequestMapping(value = "/pager")
    public String pagerSearch(Pager pager, Model model){
        List<MenuShow> menuShows = menuService.findByPager(pager);
        model.addAttribute("menuShows",menuShows);  //设置查询出来的数据
        model.addAttribute("pager", pager);  //设置分页显示数据
        return "index";
    }


}
