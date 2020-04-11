package com.springboothouse.pcontroller;


import com.springboothouse.entity.Type;
import com.springboothouse.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller("typeController2")
@RequestMapping("/page")
public class TypeController {

    @Autowired
    private TypeService typeService;

    @RequestMapping("getAllType")
    @ResponseBody
    public List<Type>  getAllType(){
        List<Type> typeList = typeService.getAllType();
        return typeList;
    }
}
