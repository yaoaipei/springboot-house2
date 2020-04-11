package com.springboothouse.pcontroller;


import com.springboothouse.entity.Users;
import com.springboothouse.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller("userController2")
@RequestMapping("/page/")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("loginAction")
    public String loginAction(String username, String password, HttpSession session){
        Users user = userService.login(username, password);
        if (user!=null){
            session.setAttribute("userinfo",user);
            //设置有效期
            //session.setMaxInactiveInterval(6000);
            //重定向跳入用户管理之前的controller层再去管理层页面
            return "redirect:getUserHouse";
        }else {
            //再次返回登录
            return "login";
        }
    }

//检查用户名
    @RequestMapping("checkName")
    @ResponseBody
    public Map<String,Object> checkName(String name){
        int i = userService.checkName(name);
        Map<String,Object>map=new HashMap<>();
        map.put("result",i);
        return map;
    }

    //实现注册添加功能
    @RequestMapping("reg")
    public String reg(Users users){
        int i = userService.addUser(users);
        if (i>0){
            return "login";
        }else {
            return "regs";
        }

    }


}
