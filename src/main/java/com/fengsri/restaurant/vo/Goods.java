package com.fengsri.restaurant.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fengwen
 * @date 2019/4/9 15:36
 */
public class Goods {
    private List<Integer> goods_id ;
    private int goods_count ;

    public Goods() {
        goods_id = new ArrayList<Integer>();
        goods_count = 0;
    }

    public List<Integer> getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(List<Integer> goods_id) {
        this.goods_id = goods_id;
    }

    public int getGoods_count() {
        return goods_count;
    }

    public void setGoods_count(int goods_count) {
        this.goods_count = goods_count;
    }
}
