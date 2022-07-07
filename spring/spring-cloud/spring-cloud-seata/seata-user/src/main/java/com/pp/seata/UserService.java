package com.pp.seata;

import com.baomidou.mybatisplus.extension.service.IService;
import io.seata.spring.annotation.GlobalTransactional;

import java.util.List;

public interface UserService extends IService<User> {


    int updateBatch(List<User> list);

    int batchInsert(List<User> list);

    int insertOrUpdate(User record);

    int insertOrUpdateSelective(User record);


    void hello();
}




