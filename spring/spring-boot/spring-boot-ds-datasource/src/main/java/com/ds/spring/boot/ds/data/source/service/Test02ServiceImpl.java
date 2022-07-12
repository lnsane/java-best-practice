package com.ds.spring.boot.ds.data.source.service;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ds.spring.boot.ds.data.source.mapper.Test01Mapper;
import com.ds.spring.boot.ds.data.source.mapper.Test02Mapper;
import com.ds.spring.boot.ds.data.source.po.Test01;
import com.ds.spring.boot.ds.data.source.po.Test02;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@DS("test")
public class Test02ServiceImpl extends ServiceImpl<Test02Mapper, Test02>  implements Test02Service {

    @Override
    public void insert(Test02 test02) {
        baseMapper.insert(test02);
    }
}
