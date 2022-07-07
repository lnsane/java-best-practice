package com.best.spring.boot.mybatis.plus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.best.spring.boot.mybatis.plus.entity.User;
import com.best.spring.boot.mybatis.plus.enums.SexEnum;
import com.best.spring.boot.mybatis.plus.mapper.UserMapper;
import com.best.spring.boot.mybatis.plus.service.UserService2;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserService2Impl extends ServiceImpl<UserMapper, User>  implements UserService2 {
    @Override
    public void insertTwo() {
        save(User.builder().username("123").sex(SexEnum.MAN).createTime(new Date()).build());
        int i = 1 / 0;
    }
}
