package com.best.spring.boot.mq.aop.t.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.best.spring.boot.mq.aop.t.model.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper extends BaseMapper<Order> {
    int updateBatch(List<Order> list);

    int batchInsert(@Param("list") List<Order> list);
}