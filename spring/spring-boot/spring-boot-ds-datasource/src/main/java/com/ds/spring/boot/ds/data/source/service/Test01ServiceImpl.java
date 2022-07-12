package com.ds.spring.boot.ds.data.source.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ds.spring.boot.ds.data.source.mapper.Test01Mapper;
import com.ds.spring.boot.ds.data.source.po.Test01;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Test01ServiceImpl extends ServiceImpl<Test01Mapper, Test01> implements Test01Service {

    @Override
    public void insert(Test01 test01) {
        baseMapper.insert(test01);
    }
}
