package com.ds.spring.boot.ds.data.source.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ds.spring.boot.ds.data.source.po.User;

import java.util.List;

public interface UserService extends IService<User> {


    int updateBatch(List<User> list);

    int batchInsert(List<User> list);

    int insertOrUpdate(User record);

    int insertOrUpdateSelective(User record);

}




