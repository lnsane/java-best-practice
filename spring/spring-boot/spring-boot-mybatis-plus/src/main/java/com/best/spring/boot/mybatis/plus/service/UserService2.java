package com.best.spring.boot.mybatis.plus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.best.spring.boot.mybatis.plus.entity.User;
import org.springframework.transaction.annotation.Transactional;

public interface UserService2 extends IService<User> {


    @Transactional
    void insertTwo();

}




