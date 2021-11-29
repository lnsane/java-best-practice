package com.best.spring.boot.transaction.controller;

import com.best.spring.boot.transaction.model.Order;
import com.best.spring.boot.transaction.service.OrderBusinessService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author lnsane
 */
@RestController
public class HelloController {
    private final OrderBusinessService orderBusinessService;

    public HelloController(OrderBusinessService orderBusinessService) {
        this.orderBusinessService = orderBusinessService;
    }

    @GetMapping
    public void hello() {
        Order order = new Order();
        order.setOrderName("1");
        order.setState(0);
        order.setCreateTime(new Date());
        order.setUpdateTime(new Date());
        orderBusinessService.save(order);
    }
}
