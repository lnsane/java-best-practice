package com.best.spring.boot.transaction.service;

import com.best.spring.boot.transaction.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author lnsane
 */
@Component
public class InnerOrderService {
    @Autowired
    private OrderService orderService;

    @Transactional
    public void save(Order order) {
        orderService.save(order);
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public void save2() {
        Order order2 = new Order();
        order2.setOrderName("2");
        order2.setState(0);
        order2.setCreateTime(new Date());
        order2.setUpdateTime(new Date());
        orderService.save(order2);
    }
}
