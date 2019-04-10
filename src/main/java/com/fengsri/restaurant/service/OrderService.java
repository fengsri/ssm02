package com.fengsri.restaurant.service;

import com.fengsri.restaurant.entity.Order;
import com.fengsri.restaurant.vo.Goods;
import com.fengsri.restaurant.vo.MenuShow;
import com.fengsri.restaurant.vo.Pager;

import java.util.List;

/**
 * @author fengwen
 * @date 2019/4/9 16:11
 */
public interface OrderService {
    /*查看购物车*/
    public List<MenuShow> getGoods(Goods goods);


    /*购买的物品总价*/
    public Float getAllPrice(Goods goods);


    /*支付*/
    public int orderPay(Goods goods,int user_id);

    /*查询订单的总页数*/
    public Integer getAllPager();

    /*分页查询*/
    public List<Order> findByPager(Pager pager);
}
