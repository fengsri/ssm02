package com.fengsri.restaurant.controller;

import com.fengsri.restaurant.entity.Order;
import com.fengsri.restaurant.entity.User;
import com.fengsri.restaurant.service.MenuService;
import com.fengsri.restaurant.service.OrderService;
import com.fengsri.restaurant.util.MenuPagerUtil;
import com.fengsri.restaurant.vo.Goods;
import com.fengsri.restaurant.vo.MenuShow;
import com.fengsri.restaurant.vo.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author fengwen
 * @date 2019/4/9 15:40
 */
@Controller
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    private MenuService menuService ; //用于查询商品

    @Autowired
    private OrderService orderService;

    //购物车添加商品
    @RequestMapping(value = "/add")
    public String add(Integer menu_id, Model model, HttpServletRequest request){
        Goods goods =(Goods) request.getSession().getAttribute("goods");  //获取商品购物车
        if(goods==null){  //购物车不为空
            goods = new Goods(); //创建一个新的购物车
        }
        List<Integer> goods_id = goods.getGoods_id();
        int goods_count = goods.getGoods_count();
        goods_id.add(menu_id);  //添加购买的物品id
        goods_count++;        //购物车商品数加1
        goods.setGoods_count(goods_count);
        goods.setGoods_id(goods_id);
        request.getSession().setAttribute("goods",goods);  //设置session

        int all_pager = menuService.getAllPager();  //当前的总的商品页数
        Pager pager = MenuPagerUtil.getMenuPager(1,all_pager);
        List<MenuShow> menuShows = menuService.findByPager(pager);
        model.addAttribute("menuShows",menuShows);  //设置查询出来的数据
        model.addAttribute("pager", pager);  //设置分页显示数据
        return "index";
    }


    //到购物页面
    @RequestMapping(value = "/to_order")
    public String toOrder(Model model ,HttpServletRequest request){
        Goods goods = (Goods)request.getSession().getAttribute("goods");
        if(goods!=null){
            List<MenuShow> menuShows = orderService.getGoods(goods);
            model.addAttribute("menuShows",menuShows);
            return "car_goods";
        }else{
            return "car_goods";
        }
    }


    //购物车页面减少商品
    @RequestMapping(value = "/reduce")
    public String reduce(Integer menu_id,Model model,HttpServletRequest request){
        Goods goods = (Goods)request.getSession().getAttribute("goods");
        if(goods!=null){
            List<Integer> goods_id = goods.getGoods_id();
            int goods_count = goods.getGoods_count();
            goods_id.remove(menu_id);  //移除该商品
            goods_count--;
            goods.setGoods_id(goods_id); //设置
            goods.setGoods_count(goods_count);
            request.getSession().setAttribute("goods",goods);  //设置session

            List<MenuShow> menuShows = orderService.getGoods(goods);  //查询商品
            model.addAttribute("menuShows",menuShows);
            return "car_goods";
        }else{
            return "car_goods";
        }
    }

    //到订单支付
    @RequestMapping(value = "/to_pay")
    public String toOrderPay(Model model,HttpServletRequest request){
        Goods goods =(Goods) request.getSession().getAttribute("goods");
        if(goods!=null){
            float all_price = orderService.getAllPrice(goods);
            model.addAttribute("all_price",all_price);
            model.addAttribute("goods_count",goods.getGoods_count());
            return "to_pay";
        }else {
            model.addAttribute("messgae","支付错误");
            return "error";
        }
    }

    //订单支付
    @RequestMapping(value = "/pay")
    public String orderPay(Model model,HttpServletRequest request){
        Goods goods =(Goods) request.getSession().getAttribute("goods");
        User user =(User) request.getSession().getAttribute("user");
        orderService.orderPay(goods,user.getUser_id());
        model.addAttribute("message","支付成功");
        request.getSession().removeAttribute("goods");//消除当前购物车东西
        return "sucess";
    }

    //到订单管理
    @RequestMapping(value = "/manager_order")
    public String managerOrder(Model model){
        int all_pager = orderService.getAllPager();  //当前的总的订单页数
        Pager pager = MenuPagerUtil.getMenuPager(1,all_pager);
        List<Order> orders = orderService.findByPager(pager);
        model.addAttribute("orders",orders);
        model.addAttribute("pager",pager);
        return "order_manager";
    }

    /*订单管理分页查询*/
    @RequestMapping(value = "/pager")
    public String orderPager(Pager pager,Model model){
        List<Order> orders = orderService.findByPager(pager);
        model.addAttribute("orders",orders);
        return "order_manager";
    }


}
