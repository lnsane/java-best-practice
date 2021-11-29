package com.best.spring.boot.mq.aop.t.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.best.spring.boot.mq.aop.t.model.Order;

import java.util.List;
public interface OrderService extends IService<Order>{


    int updateBatch(List<Order> list);

    int batchInsert(List<Order> list);

}
