package com.fengsri.restaurant.dao;

import com.fengsri.restaurant.vo.Pager;
import com.fengsri.restaurant.vo.MenuShow;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author fengwen
 * @date 2019/4/8 19:51
 */
public interface MenuDao {

    /*查询所有的商品*/
    public List<MenuShow> findAllMenu();

    /*分页查询*/
    public List<MenuShow> findByPager(Pager pager);

    /*查询商品的总的数量*/
    public Integer getAllMenuCount();

    /*价格范围查询*/


    /*商品名模糊*/
    public List<MenuShow> searchMenu(@Param(value = "menu_like") String menu_like);

    /*根据商品的menu_id查询商品的基本信息*/
    public MenuShow findById(@Param(value = "menu_id")Integer menu_id);

}
