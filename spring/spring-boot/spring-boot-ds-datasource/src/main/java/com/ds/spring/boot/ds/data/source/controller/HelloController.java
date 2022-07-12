package com.ds.spring.boot.ds.data.source.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.ds.spring.boot.ds.data.source.config.ShardingJDBC;
import com.ds.spring.boot.ds.data.source.po.Test01;
import com.ds.spring.boot.ds.data.source.po.Test02;
import com.ds.spring.boot.ds.data.source.po.User;
import com.ds.spring.boot.ds.data.source.service.Test01Service;
import com.ds.spring.boot.ds.data.source.service.Test02Service;
import com.ds.spring.boot.ds.data.source.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    private Test01Service test01Service;
    @Autowired
    private Test02Service test02Service;

    @Autowired
    private UserService userService;

    @GetMapping("test01")
    public void test01(){
        Test01 test01 = new Test01();
        test01.setId((int) System.currentTimeMillis());
        test01.setName(String.valueOf(System.currentTimeMillis()));
        test01Service.insert(test01);
    }

    @GetMapping("test02")
    public void test02(){
        Test02 test01 = new Test02();
        test01.setId((int) System.currentTimeMillis());
        test01.setAge(123);
        test02Service.insert(test01);
    }

    @GetMapping("user")
    @ShardingJDBC
    public void user(){
//        User user = new User();
//        user.setId(IdUtil.getSnowflakeNextIdStr());
//        user.setCity("1");
//        user.setName("231");
        User one = userService.getOne(Wrappers.<User>lambdaQuery().eq(User::getName, "1"));
        System.out.println(one);
    }


}
