package com.springboothouse.mapper;

import com.springboothouse.entity.District;
import com.springboothouse.entity.DistrictExample;

import java.util.List;

public interface DistrictMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(District record);

    int insertSelective(District record);

    List<District> selectByExample(DistrictExample example);

    District selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(District record);

    int updateByPrimaryKey(District record);

    //批量删除区域   也可以传String/list类型  String ids="1006,1007"  Inteage[]ids={1006,1007}
    int deleteMoreDistrict(Integer[] ids);
}