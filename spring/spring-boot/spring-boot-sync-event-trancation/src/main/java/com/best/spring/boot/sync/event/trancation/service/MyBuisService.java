package com.best.spring.boot.sync.event.trancation.service;

import com.best.spring.boot.sync.event.trancation.event.GoodsEventListener;
import com.best.spring.boot.sync.event.trancation.model.Order;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.ILoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.security.CodeSource;
import java.security.ProtectionDomain;
import java.util.Date;

/**
 * @author lnsane
 */
@Component
@Slf4j
public class MyBuisService  {
    @Autowired
    private OrderService orderService;
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    private Object getLocation(ILoggerFactory factory) {
        try {
            ProtectionDomain protectionDomain = factory.getClass().getProtectionDomain();
            CodeSource codeSource = protectionDomain.getCodeSource();
            if (codeSource != null) {
                return codeSource.getLocation();
            }
        }
        catch (SecurityException ex) {
            // Unable to determine location
        }
        return "unknown location";
    }
    @Transactional
    public void save() {
        log.info("开始事件");
        Order order = new Order();
        order.setOrderName("");
        order.setState(0);
        order.setCreateTime(new Date());
        order.setUpdateTime(new Date());
        orderService.save(order);
        applicationEventPublisher.publishEvent(new GoodsEventListener(this, order.getId()));
        log.info("结束事件");
    }


}
