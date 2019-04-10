package com.fengsri.restaurant.dao;

import com.fengsri.restaurant.entity.User;
import com.fengsri.restaurant.vo.Pager;
import com.fengsri.restaurant.vo.UserShow;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
    /*用户分页查询*/
    public List<UserShow> findByPager(Pager pager);

    /*查询用户的总的数量*/
    public Integer getAllUserCount();


    /*用户名名模糊*/
    public List<UserShow> searchUser(@Param(value = "user_like") String user_like);

    /*通过用户user_id查询用户信息*/
    public UserShow findById(@Param(value = "user_id") Integer user_id);


    /*修改用户的基本信息*/
    public int modify(User user);

    /*删除用户user_id*/
    public int delete(@Param(value = "user_id") Integer user_id);

    /*添加用户*/
    public int add(User user);

}
