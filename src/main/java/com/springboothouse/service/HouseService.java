package com.springboothouse.service;

import com.github.pagehelper.PageInfo;
import com.springboothouse.entity.House;
import com.springboothouse.utils.HouseCondition;

import java.util.List;

public interface HouseService {


    /**
     * 查询用户的出租房信息
     * @param uid 用户编号
     * @return  出租房信息
     */
    public List<House> getHouseByUserid(Integer uid);




    /**
     * 查询某条出租房信息
     * @param id  出租房编号
     * @return 出租房的实体
     */
    public House getHouseById(String id);

    /**
     * 修改出租房
     * @param house
     * @return  影响行数
     */
    public int updateHouse(House house);

    /**
     * 发布出租房
     * @param house  实体
     * @return 影响行数
     */

    public int addHouse(House house);

    /**
     * 查询所有浏览出租房信息
     * @param condition  查询条件  分页page,rows
     * @return
     */

    public PageInfo<House> getHouseByBroswer(HouseCondition condition);

}
