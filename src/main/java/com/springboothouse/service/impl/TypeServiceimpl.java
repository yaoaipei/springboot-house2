package com.springboothouse.service.impl;

import com.springboothouse.entity.Type;
import com.springboothouse.entity.TypeExample;
import com.springboothouse.mapper.TypeMapper;
import com.springboothouse.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TypeServiceimpl implements TypeService {

    @Autowired
    private TypeMapper typeMapper;


    @Override
    public List<Type> getAllType() {
        return typeMapper.selectByExample(new TypeExample());

    }
}
