package com.pp.seata;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
//    @Select("select *\n" +
//            "        from user\n" +
//            "        where exists (select *\n" +
//            "        from user\n" +
//            "        where user.username in ('wangcunlu')\n" +
//            "        limit 1)")
    Boolean selectExist();
}