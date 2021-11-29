package com.best.spring.boot.mq.aop.t.service.lmpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.best.spring.boot.mq.aop.t.mapper.OrderMapper;
import com.best.spring.boot.mq.aop.t.model.Order;
import com.best.spring.boot.mq.aop.t.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService{

    @Override
    public int updateBatch(List<Order> list) {
        return baseMapper.updateBatch(list);
    }
    @Override
    public int batchInsert(List<Order> list) {
        return baseMapper.batchInsert(list);
    }
}
