package com.springboothouse.controller;


import com.github.pagehelper.PageInfo;
import com.springboothouse.entity.District;
import com.springboothouse.service.DistrictService;
import com.springboothouse.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin/")
public class DistrictController {

    @Autowired
    private DistrictService districtService;

    @RequestMapping("getAllDistrict")
    @ResponseBody
    public List<District> getAllDistrict(){
        List<District> allDistrict = districtService.getAllDistrict();
        return allDistrict;
    }


    //分页查询所有显示于页面
    //由于前端使用的datagrid 所以他自动传参 page 页码,rows页大小
    @RequestMapping("getDistrictByPage")
    @ResponseBody
    public Map<String,Object> getDistrictByPage(PageUtil pageUtil){
        PageInfo<District> pageinfo = districtService.getDisrictByPage(pageUtil);
        Map<String,Object>map=new HashMap<>();
        map.put("rows",pageinfo.getList());
        map.put("total",pageinfo.getTotal());
        return map;
    }


    //添加区域

    @RequestMapping("addDistrit")
    @ResponseBody
    public Map<String,Object> addDistrit(District district){
        int i = districtService.addDistrict(district);
        Map<String,Object>map=new HashMap<>();
        map.put("result",i);
        return map;
    }

    //接由前端传递的区域编号，查询当前记录
    @RequestMapping("getDistrit")
    @ResponseBody
    public District getDistrit(Integer id){
        District district = districtService.getDistrict(id);
        return district;
    }

    //修改区域
    @RequestMapping("upDistrit")
    @ResponseBody
    public Map<String,Object> upDistrit(District district){
        int i = districtService.updateDistrict(district);
    Map<String,Object>map=new HashMap<>();
    map.put("result",i);//自动将对象转化为json
    return map;
    }

    //删除区域
    @RequestMapping("delDistrict")
    @ResponseBody
    public Map<String,Object> delDistrict(Integer id){
        int i = districtService.delDistrict(id);
        Map<String,Object>map=new HashMap<>();
        map.put("result",i);//自动将对象转化为json
        return map;
    }

    //批量删除区域  delMoreDistrit?ids=1006&ids=1007  ====>Integer []ids
// delMoreDistrit?ids=1006,1007  ====>String ids
    @RequestMapping("delMoreDistrit")
    @ResponseBody
    public Map<String,Object> delMoreDistrit(String ids){
        //将字符串转化为数组  {1006,1007}
        String[] list = ids.split(",");
        Integer[]array=new Integer[list.length];
        for (int i = 0; i < list.length; i++) {
            array[i]=Integer.parseInt(list[i]);
        }
        int i = districtService.delMoreDistrict(array);
        Map<String,Object>map=new HashMap<>();
        map.put("result",i);//自动将对象转化为json
        return map;
    }
}
