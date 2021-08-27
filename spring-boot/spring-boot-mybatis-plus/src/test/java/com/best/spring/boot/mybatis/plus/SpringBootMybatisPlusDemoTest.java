package com.best.spring.boot.mybatis.plus;

import com.best.spring.boot.mybatis.plus.entity.User;
import com.best.spring.boot.mybatis.plus.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class SpringBootMybatisPlusDemoTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    void main() {
        userMapper.insert(User.builder().username("root1").createTime(new Date()).updateTime(new Date()).build());
    }
}