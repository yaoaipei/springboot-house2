package com.springboothouse.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springboothouse.entity.District;
import com.springboothouse.entity.DistrictExample;
import com.springboothouse.mapper.DistrictMapper;
import com.springboothouse.service.DistrictService;
import com.springboothouse.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DistrictServiceimpl implements DistrictService {
    @Autowired
    private DistrictMapper districtMapper;

    @Override
    public List<District> getAllDistrict() {
        List<District> districts = districtMapper.selectByExample(new DistrictExample());
        return districts;
    }


    @Override
    public PageInfo<District> getDisrictByPage(PageUtil pageinfo) {
        //1.开启分页
        PageHelper.startPage(pageinfo.getPage(),pageinfo.getRows());
        //2.查询所有
        List<District> list = districtMapper.selectByExample(new DistrictExample());
        //3.获取分页信息
        PageInfo<District>pageInfo1=new PageInfo<>(list);
        return pageInfo1;
    }

    @Override
    public int addDistrict(District district) {
        int  i= districtMapper.insertSelective(district);
        return i;
    }

    @Override
    public District getDistrict(Integer id) {
        District district = districtMapper.selectByPrimaryKey(id);
        return district;
    }


    @Override
    public int updateDistrict(District district) {
        int i = districtMapper.updateByPrimaryKeySelective(district);
        return i;
    }

    @Override
    public int delDistrict(Integer id) {
        return districtMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int delMoreDistrict(Integer[] ids) {
        return districtMapper.deleteMoreDistrict(ids);
    }
}
