package com.best.spring.boot.mq.aop.t.service;

import com.best.spring.boot.mq.aop.t.model.Order;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author lnsane
 */
public interface Azom {
    @Transactional
    void put(Order msg, Channel channel, Message message);

    void download(Order msg,Channel channel,Message message);
}
