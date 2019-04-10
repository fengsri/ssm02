package com.fengsri.restaurant.service;

import com.fengsri.restaurant.vo.Pager;
import com.fengsri.restaurant.vo.MenuShow;

import java.util.List;

/**
 * @author fengwen
 * @date 2019/4/8 19:57
 */
public interface MenuService {
    /*查询所有的商品*/
    public List<MenuShow> findAllMenu();

    /*分页查询*/
    public List<MenuShow> findByPager(Pager pager);

    /*查询商品的总页数*/
    public Integer getAllPager();


    /*商品名进行模糊查询*/
    public List<MenuShow> searchMenu(String menu_like);

}
