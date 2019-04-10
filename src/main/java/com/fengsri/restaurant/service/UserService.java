package com.fengsri.restaurant.service;

import com.fengsri.restaurant.entity.User;
import com.fengsri.restaurant.vo.MenuShow;
import com.fengsri.restaurant.vo.Pager;
import com.fengsri.restaurant.vo.UserShow;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author fengwen
 * @date 2019/4/8 19:57
 */
public interface UserService {
    /*用户分页查询*/
    public List<UserShow> findByPager(Pager pager);

    /*查询用户的总页数*/
    public Integer getAllPager();

    /*用户名名模糊*/
    public List<UserShow> searchUser(String user_like);

    /*通过用户user_id查询用户信息*/
    public UserShow findById(Integer user_id);

    /*修改用户的基本信息*/
    public int modify(UserShow userShow);

    /*删除用户user_id*/
    public int delete(Integer user_id);

    /*添加用户*/
    public int add(UserShow userShow);
}
