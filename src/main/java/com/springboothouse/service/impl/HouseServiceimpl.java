package com.springboothouse.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springboothouse.entity.House;
import com.springboothouse.mapper.HouseMapper;
import com.springboothouse.service.HouseService;
import com.springboothouse.utils.HouseCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class HouseServiceimpl implements HouseService {



    //通过用户所有
    @Autowired
    private HouseMapper houseMapper;
    @Override
    public List<House> getHouseByUserid(Integer uid) {
        List<House> houseList = houseMapper.getHouseByUser(uid);
        return houseList;
    }

//通过用户id查某条
    @Override
    public House getHouseById(String id) {
        House house = houseMapper.getHouseById(id);
        return house;
    }

    @Override
    public int updateHouse(House house) {
        int i = houseMapper.updateByPrimaryKeySelective(house);
        return i;
    }

//添加发布
    @Override
    public int addHouse(House house) {
        return houseMapper.insertSelective(house);
    }

    @Override
    public PageInfo<House> getHouseByBroswer(HouseCondition condition) {
        //1.开启分页
        PageHelper.startPage(condition.getPage(),condition.getRows());
        //2.查询
        List<House> list = houseMapper.getHouseByBroswer(condition);
        //3.获取分页信息
        PageInfo<House>pageInfo=new PageInfo<>(list);

        return pageInfo;
    }
}
