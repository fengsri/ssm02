package com.fengsri.restaurant.service.impl;

import com.fengsri.restaurant.dao.MenuDao;
import com.fengsri.restaurant.dao.UserDao;
import com.fengsri.restaurant.entity.User;
import com.fengsri.restaurant.service.MenuService;
import com.fengsri.restaurant.service.UserService;
import com.fengsri.restaurant.vo.MenuShow;
import com.fengsri.restaurant.vo.Pager;
import com.fengsri.restaurant.vo.UserShow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author fengwen
 * @date 2019/4/8 19:58
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    /*用户分页查询*/
    @Override
    public List<UserShow> findByPager(Pager pager) {
        return userDao.findByPager(pager);
    }

    /*查询用户的总页数*/
    @Override
    public Integer getAllPager() {
        int all_pager = 0 ;
        if(((userDao.getAllUserCount())%(Pager.PAGER_COUNT))==0)
            all_pager =(int)((userDao.getAllUserCount())/(Pager.PAGER_COUNT));
        else
            all_pager =(int)((userDao.getAllUserCount())/(Pager.PAGER_COUNT))+1 ;
        return all_pager;
    }

    /*用户名名模糊*/
    @Override
    public List<UserShow> searchUser(String user_like) {
        return userDao.searchUser(user_like);
    }

    /*通过用户user_id查询用户信息*/
    public UserShow findById(Integer user_id){
        return userDao.findById(user_id);
    }


    /*修改用户的基本信息*/
    public int modify(UserShow userShow){
        String type_name = userShow.getUser_type_name();
        int user_type_id = 1;
        if(type_name.equals("游客")){
            user_type_id = 1;
        }else if(type_name.equals("管理员")){
            user_type_id = 2;
        }
        User user = new User(userShow.getUser_id(),userShow.getUser_name(),userShow.getUser_password(),userShow.getUser_phone(),userShow.getUser_address(),user_type_id);
        return userDao.modify(user);
    }

    /*删除用户user_id*/
    public int delete(Integer user_id){
        return userDao.delete(user_id);
    }

    /*添加用户*/
    public int add(UserShow userShow){
        String user_type_name = userShow.getUser_type_name();
        int user_type_id = 1;
        if(user_type_name.equals("游客")){
            user_type_id = 1;
        }else if(user_type_name.equals("管理员")){
            user_type_id = 2;
        }
        User user = new User();
        user.setUser_name(userShow.getUser_name());
        user.setUser_password(userShow.getUser_password());
        user.setUser_phone(userShow.getUser_phone());
        user.setUser_address(userShow.getUser_address());
        user.setUser_type_id(user_type_id);
        return userDao.add(user);
    }

}
