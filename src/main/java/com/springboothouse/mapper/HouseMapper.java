package com.springboothouse.mapper;

import com.springboothouse.entity.House;
import com.springboothouse.entity.HouseExample;
import com.springboothouse.utils.HouseCondition;

import java.util.List;

public interface HouseMapper {
    int deleteByPrimaryKey(String id);

    int insert(House record);

    int insertSelective(House record);

    List<House> selectByExample(HouseExample example);

    House selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(House record);

    int updateByPrimaryKey(House record);


    //一功能一方法
    //查询用户所有房屋信息
    //List<ExtHouse> getHouseByUser(Integer userid);
    List<House> getHouseByUser(Integer userid);

    //查询某条房屋信息
    House getHouseById(String id);

    //实现浏览出租房   插件分页，无需考虑分页
    List<House> getHouseByBroswer(HouseCondition condition);
}