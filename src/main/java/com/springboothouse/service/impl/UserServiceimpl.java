package com.springboothouse.service.impl;

import com.github.pagehelper.PageInfo;
import com.springboothouse.entity.Users;
import com.springboothouse.entity.UsersExample;
import com.springboothouse.mapper.UsersMapper;
import com.springboothouse.service.UserService;
import com.springboothouse.utils.MD5Utils;
import com.springboothouse.utils.UserCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceimpl implements UserService {
    @Autowired
    private UsersMapper usersMapper;

    @Override
    public Users login(String username, String password) {
        UsersExample usersExample = new UsersExample();
        UsersExample.Criteria criteria = usersExample.createCriteria();
        //用户名和密码条件
        criteria.andNameEqualTo(username);
        criteria.andPasswordEqualTo(MD5Utils.md5Encrypt(password));
        //执行
        List<Users> usersList = usersMapper.selectByExample(usersExample);
        if (usersList.size()==0){
            return null;
        }
        return usersList.get(0);
    }

    @Override
    public int checkName(String name) {
        UsersExample usersExample=new UsersExample();
        UsersExample.Criteria criteria = usersExample.createCriteria();
        criteria.andNameEqualTo(name);
        //执行
        List<Users> usersList = usersMapper.selectByExample(usersExample);

        return usersList.size();
    }

    @Override
    public int addUser(Users users) {
        //使用md5工具类对密码加密码
        users.setPassword(MD5Utils.md5Encrypt(users.getPassword()));
        //设置isadmin默认为0
        users.setIsadmin(0);
        int i = usersMapper.insertSelective(users);
        return i;
    }

//
//    @Override
//    public PageInfo<Users> getUserByCondition(UserCondition userCondition) {
//        return null;
//    }
}
