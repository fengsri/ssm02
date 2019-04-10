package com.fengsri.restaurant.vo;

import com.fengsri.restaurant.entity.Menu;
import com.fengsri.restaurant.entity.MenuType;

/**
 * @author fengwen
 * @date 2019/4/8 20:17
 */
public class MenuShow {
    private int menu_id;
    private String menu_name;
    private Float menu_price;
    private String menu_pic;
    private String menu_dis;
    private String menu_type_name;

    public MenuShow() {
    }

    public int getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(int menu_id) {
        this.menu_id = menu_id;
    }

    public String getMenu_name() {
        return menu_name;
    }

    public void setMenu_name(String menu_name) {
        this.menu_name = menu_name;
    }

    public Float getMenu_price() {
        return menu_price;
    }

    public void setMenu_price(Float menu_price) {
        this.menu_price = menu_price;
    }

    public String getMenu_pic() {
        return menu_pic;
    }

    public void setMenu_pic(String menu_pic) {
        this.menu_pic = menu_pic;
    }

    public String getMenu_dis() {
        return menu_dis;
    }

    public void setMenu_dis(String menu_dis) {
        this.menu_dis = menu_dis;
    }

    public String getMenu_type_name() {
        return menu_type_name;
    }

    public void setMenu_type_name(String menu_type_name) {
        this.menu_type_name = menu_type_name;
    }
}
