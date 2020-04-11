package com.springboothouse.service;

import com.springboothouse.entity.Street;

import java.util.List;

public interface StreetService {

    //一功能一方法

    /**
     * 通过区域查询对应的街道
     * @param districtId
     * @return
     */

    public List<Street> getStreetByDistrictId(Integer districtId);
}
