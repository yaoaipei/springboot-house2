package com.springboothouse.service.impl;


import com.springboothouse.entity.Street;
import com.springboothouse.entity.StreetExample;
import com.springboothouse.mapper.StreetMapper;
import com.springboothouse.service.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StreetServiceimpl implements StreetService {


    @Autowired
    private StreetMapper streetMapper;

    @Override
    public List<Street> getStreetByDistrictId(Integer districtId) {
        StreetExample streetExample = new StreetExample();
        StreetExample.Criteria criteria = streetExample.createCriteria();
        criteria.andDistrictIdEqualTo(districtId);
        List<Street> streetList = streetMapper.selectByExample(streetExample);

        return streetList;
    }
}
