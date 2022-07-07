package com.best.spring.boot.mybatis.plus.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.best.spring.boot.mybatis.plus.entity.User;
import com.best.spring.boot.mybatis.plus.enums.SexEnum;
import com.best.spring.boot.mybatis.plus.mapper.UserMapper;
import com.best.spring.boot.mybatis.plus.service.UserService;
import com.best.spring.boot.mybatis.plus.service.UserService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {


    @Autowired

    private UserService2 userService2;
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

    @Override
    public void insertOne() {
        save(User.builder().username("456").sex(SexEnum.MAN).createTime(new Date()).build());
        try {
            userService2.insertTwo();
        } catch (Exception e) {
            System.out.println(e);
        }


    }

    @Override
    public void insertTwo() {
        User one = getOne(Wrappers.<User>lambdaQuery().eq(User::getUsername, "123"));
        one.setUsername("12312312312");
        updateById(one);

        try {
            Thread.sleep(199999);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}




