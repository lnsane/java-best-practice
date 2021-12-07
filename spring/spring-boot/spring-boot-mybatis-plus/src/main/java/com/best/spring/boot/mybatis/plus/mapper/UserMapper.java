package com.best.spring.boot.mybatis.plus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.best.spring.boot.mybatis.plus.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    int updateBatch(List<User> list);

    int batchInsert(@Param("list") List<User> list);

    int insertOrUpdate(User record);

    int insertOrUpdateSelective(User record);

    int updateBatchSelective(List<User> list);

    @Select("select * from user where create_time > #{createTime}")
    List<User> selectUserByCreateTime(Date createTime);
}