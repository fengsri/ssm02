package com.fengsri.restaurant.util;

import com.fengsri.restaurant.vo.Pager;

/**
 * @author fengwen
 * @date 2019/4/8 22:25
 */
public class MenuPagerUtil {
    public static Pager getMenuPager(int current_pager, int all_pager){
        Pager pager =new Pager();
        pager.setCurrent_pager(current_pager);
        pager.setAll_pager(all_pager);
        return pager;
    }
}
