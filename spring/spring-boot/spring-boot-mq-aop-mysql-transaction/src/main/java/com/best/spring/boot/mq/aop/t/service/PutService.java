package com.best.spring.boot.mq.aop.t.service;

import com.best.spring.boot.mq.aop.t.model.Order;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author lnsane
 */
public interface PutService {
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    void putOne(Order msg, Channel channel, Message message);

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    void putTwo(Order mes, Channel channel, Message message);
}
