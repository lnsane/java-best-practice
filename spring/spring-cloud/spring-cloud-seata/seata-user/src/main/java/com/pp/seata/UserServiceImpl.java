package com.pp.seata;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pp.seata.fegin.HelloFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private HelloFeign helloFeign;

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
    public void hello() {
        baseMapper.insert(User.builder().username("1111111").build());
        helloFeign.isExist();
        System.out.println("1");
    }
}




