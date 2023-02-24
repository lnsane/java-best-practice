package com.best.spring.boot.transaction.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.best.spring.boot.transaction.model.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface OrderMapper extends BaseMapper<Order> {
    int updateBatch(List<Order> list);

    int batchInsert(@Param("list") List<Order> list);

    @Update("truncate table `order`")
    void del();
}