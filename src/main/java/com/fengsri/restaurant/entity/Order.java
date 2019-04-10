package com.fengsri.restaurant.entity;

/**
 * @author fengwen
 * @date 2019/4/8 11:03
 */
public class Order {
    private String order_id;
    private String order_date;
    private int user_id;
    public Order() {
    }

    public Order(String order_id, String order_date, int user_id) {
        this.order_id = order_id;
        this.order_date = order_date;
        this.user_id = user_id;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getOrder_date() {
        return order_date;
    }

    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
