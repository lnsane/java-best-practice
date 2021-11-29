package com.best.spring.boot.mybatis.plus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.best.spring.boot.mybatis.plus.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {
    int updateBatch(List<User> list);

    int batchInsert(@Param("list") List<User> list);

    int insertOrUpdate(User record);

    int insertOrUpdateSelective(User record);

    int updateBatchSelective(List<User> list);
}