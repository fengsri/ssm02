package com.fengsri.restaurant.dao;

import com.fengsri.restaurant.entity.Detail;
import com.fengsri.restaurant.entity.Order;
import com.fengsri.restaurant.vo.Pager;

import java.util.List;

public interface OrderDao {
    /*根据order_id查询订单*/
    public Order findById(int order_id);

    /*保存订单*/
    public int saveOrder(Order order);

    /*保存订单明细*/
    public int saveDetail(Detail detail);


    /*订单数量*/
    public int allOrderCount();

    /*分页查询*/
    public List<Order> findByPager(Pager pager);
}
