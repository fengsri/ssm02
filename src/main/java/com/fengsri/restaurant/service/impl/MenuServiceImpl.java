package com.fengsri.restaurant.service.impl;

import com.fengsri.restaurant.dao.MenuDao;
import com.fengsri.restaurant.service.MenuService;
import com.fengsri.restaurant.vo.Pager;
import com.fengsri.restaurant.vo.MenuShow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author fengwen
 * @date 2019/4/8 19:58
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuDao dao;


    /*查询所有的商品*/
    public List<MenuShow> findAllMenu(){
        return dao.findAllMenu();
    }


    /*分页查询*/
    @Override
    public List<MenuShow> findByPager(Pager pager) {
        return dao.findByPager(pager);
    }

    /*查询商品的总页数*/
    public Integer getAllPager(){
        int all_pager = 0 ;
        if(((dao.getAllMenuCount())%(Pager.PAGER_COUNT))==0)
            all_pager =(int)((dao.getAllMenuCount())/(Pager.PAGER_COUNT));
        else
            all_pager =(int)((dao.getAllMenuCount())/(Pager.PAGER_COUNT))+1 ;
        return all_pager;
    }

    /*商品名进行模糊查询*/
    public List<MenuShow> searchMenu(String menu_like){
        return dao.searchMenu(menu_like);
    }
}
