package com.fengsri.restaurant.entity;

/**
 * @author fengwen
 * @date 2019/4/8 11:04
 */
public class Detail {
    private String order_id;
    private Integer menu_id;
    private int detail_count;

    public Detail() {
    }

    public Detail(String order_id, Integer menu_id, int detail_count) {
        this.order_id = order_id;
        this.menu_id = menu_id;
        this.detail_count = detail_count;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public Integer getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(Integer menu_id) {
        this.menu_id = menu_id;
    }

    public int getDetail_count() {
        return detail_count;
    }

    public void setDetail_count(int detail_count) {
        this.detail_count = detail_count;
    }
}
