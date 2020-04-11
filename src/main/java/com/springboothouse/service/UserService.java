package com.springboothouse.service;

import com.github.pagehelper.PageInfo;
import com.springboothouse.entity.Users;
import com.springboothouse.utils.HouseCondition;
import com.springboothouse.utils.UserCondition;

public interface UserService {


    //实现用户登陆
   public Users login(String username, String password);

   //检查用户是否存在
    public int checkName(String name);


    /**
     * 注册用户  房东
     * @param users  用户信息
     * @return 影响行数
     */
    public int addUser(Users users);

//    ////带条件模糊搜索用户 及分页
//    public PageInfo<Users> getUserByCondition(UserCondition userCondition);
}
