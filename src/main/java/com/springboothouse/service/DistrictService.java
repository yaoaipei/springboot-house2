package com.springboothouse.service;

import com.github.pagehelper.PageInfo;
import com.springboothouse.entity.District;
import com.springboothouse.utils.PageUtil;

import java.util.List;

public interface DistrictService {
    //一功能一方法
    public List<District> getAllDistrict();


    //查询所有区域支持分页
    public PageInfo<District> getDisrictByPage(PageUtil pageinfo);

    /**
     * 添加区域
     * @param district
     * @return 影响行数
     */
    public int addDistrict(District district);


    /**
     * 能过编号获取区域单条记录
     * @param id 编号
     * @return 区域对象
     */
    public District getDistrict(Integer id);


    /**
     * 修改区域信息
     * @param district   区域信息的实体
     * @return  影响行数
     */
    public int updateDistrict(District district);

    //删除区域
    public int delDistrict(Integer id);

    //批量删除
    public int delMoreDistrict(Integer[] ids);
}
