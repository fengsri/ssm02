package com.fengsri.restaurant.service.impl;

import com.fengsri.restaurant.dao.MenuDao;
import com.fengsri.restaurant.dao.OrderDao;
import com.fengsri.restaurant.entity.Detail;
import com.fengsri.restaurant.entity.Order;
import com.fengsri.restaurant.service.OrderService;
import com.fengsri.restaurant.util.OrderUtil;
import com.fengsri.restaurant.util.TimeUtil;
import com.fengsri.restaurant.vo.Goods;
import com.fengsri.restaurant.vo.MenuShow;
import com.fengsri.restaurant.vo.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fengwen
 * @date 2019/4/9 16:12
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private MenuDao menuDao;//用户查询订单的商品

    @Autowired
    private OrderDao orderDao;

    /*查看购物车*/
    public List<MenuShow> getGoods(Goods goods){
        List<MenuShow> menuShows = new ArrayList<MenuShow>();
        List<Integer> goods_id = goods.getGoods_id();
        for(Integer menu_id:goods_id){
            MenuShow menuShow  = menuDao.findById(menu_id);
            if(menuShow!=null){
                menuShows.add(menuShow);
            }
        }
        return menuShows;
    }


    /*购买的物品总价*/
    public Float getAllPrice(Goods goods){
        Float all_price = 0f;
        List<Integer> goods_id = goods.getGoods_id();
        for(Integer menu_id:goods_id) {
            MenuShow menuShow = menuDao.findById(menu_id);
            if (menuShow != null) {
                all_price = all_price + menuShow.getMenu_price();
            }
        }
        return all_price;
    }


    /*支付*/
    @Transactional
    public int orderPay(Goods goods,int user_id){
        String order_id = OrderUtil.getOrderId();
        String order_date = TimeUtil.getOrderDayTime();
        orderDao.saveOrder(new Order(order_id,order_date,user_id));  //保存订单

        //下面保存订单的每个明细
        List<Integer> goods_id = goods.getGoods_id();
        for(Integer menu_id:goods_id) {
            orderDao.saveDetail(new Detail(order_id,menu_id,1));
        }
        return 1;
    }

    /*查询订单的总页数*/
    public Integer getAllPager(){
        int all_pager = 0 ;
        if(((orderDao.allOrderCount())%(Pager.PAGER_COUNT))==0)
            all_pager =(int)((orderDao.allOrderCount())/(Pager.PAGER_COUNT));
        else
            all_pager =(int)((orderDao.allOrderCount())/(Pager.PAGER_COUNT))+1 ;
        return all_pager;
    }


    /*分页查询*/
    public List<Order> findByPager(Pager pager){
        return orderDao.findByPager(pager);
    }
}
