package com.fengsri.restaurant.entity;

/**
 * @author fengwen
 * @date 2019/4/8 11:02
 */
public class MenuType {
    private int menu_type_id;
    private String menu_type_name;

    public MenuType() {
    }

    public MenuType(int menu_type_id, String menu_type_name) {
        this.menu_type_id = menu_type_id;
        this.menu_type_name = menu_type_name;
    }

    public void setMenu_type_id(int menu_type_id) {
        this.menu_type_id = menu_type_id;
    }

    public void setMenu_type_name(String menu_type_name) {
        this.menu_type_name = menu_type_name;
    }
}
