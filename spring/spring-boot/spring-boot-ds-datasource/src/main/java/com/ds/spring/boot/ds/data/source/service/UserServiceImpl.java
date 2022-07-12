package com.ds.spring.boot.ds.data.source.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ds.spring.boot.ds.data.source.mapper.UserMapper;
import com.ds.spring.boot.ds.data.source.po.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {


    @Override
    public int updateBatch(List<User> list) {
        return baseMapper.updateBatch(list);
    }

    @Override
    public int batchInsert(List<User> list) {
        return baseMapper.batchInsert(list);
    }

    @Override
    public int insertOrUpdate(User record) {
        return baseMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(User record) {
        return baseMapper.insertOrUpdateSelective(record);
    }


}




