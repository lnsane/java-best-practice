package com.best.spring.boot.mybatis.plus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.best.spring.boot.mybatis.plus.entity.User;

import java.util.List;

public interface UserService extends IService<User> {


    int updateBatch(List<User> list);

    int batchInsert(List<User> list);

    int insertOrUpdate(User record);

    int insertOrUpdateSelective(User record);

}




