package com.best.spring.boot.sync.event.trancation.service;

import com.best.spring.boot.sync.event.trancation.event.GoodsEventListener;
import com.best.spring.boot.sync.event.trancation.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author lnsane
 */
@Component
public class MyBuisService {
    @Autowired
    private OrderService orderService;
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Transactional
    public void save() {
        Order order = new Order();
        order.setOrderName("");
        order.setState(0);
        order.setCreateTime(new Date());
        order.setUpdateTime(new Date());
        applicationEventPublisher.publishEvent(new GoodsEventListener(this, order.getId()));
        orderService.save(order);
        if ( 1 / 0 == 1) {

        }
    }
}
