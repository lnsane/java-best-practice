package com.best.spring.boot.mybatis.plus;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
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
        User root1 = User.builder().username("root1").createTime(new Date()).updateTime(new Date()).build();
//        userMapper.insert(root1);
//        System.out.println(root1);
    }

    @Test
    void main2() {
        User user = userMapper.selectOne(Wrappers.<User>lambdaQuery().last("limit 1"));
        System.out.println(user);
    }
}