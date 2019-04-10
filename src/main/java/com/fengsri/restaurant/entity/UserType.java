package com.fengsri.restaurant.entity;

/**
 * @author fengwen
 * @date 2019/4/8 10:57
 */
public class UserType {
    private int user_type_id;
    private String user_type_name;

    public UserType() {
    }

    public UserType(int user_type_id, String user_type_name) {
        this.user_type_id = user_type_id;
        this.user_type_name = user_type_name;
    }


    public int getUser_type_id() {
        return user_type_id;
    }

    public void setUser_type_id(int user_type_id) {
        this.user_type_id = user_type_id;
    }

    public String getUser_type_name() {
        return user_type_name;
    }

    public void setUser_type_name(String user_type_name) {
        this.user_type_name = user_type_name;
    }
}
