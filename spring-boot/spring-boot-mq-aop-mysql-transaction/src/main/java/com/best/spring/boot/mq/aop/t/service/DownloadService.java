package com.best.spring.boot.mq.aop.t.service;

import com.best.spring.boot.mq.aop.t.model.Order;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author lnsane
 */
public interface DownloadService {
    @Transactional
    void downloadOne(Order order, Channel channel, Message message);
    @Transactional
    void downloadTwo(Order order, Channel channel, Message message);
}
