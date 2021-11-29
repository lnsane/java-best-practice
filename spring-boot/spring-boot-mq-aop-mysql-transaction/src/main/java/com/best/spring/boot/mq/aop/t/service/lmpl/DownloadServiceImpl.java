package com.best.spring.boot.mq.aop.t.service.lmpl;

import com.best.spring.boot.mq.aop.t.model.Order;
import com.best.spring.boot.mq.aop.t.service.DownloadService;
import com.best.spring.boot.mq.aop.t.service.OrderService;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronization;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.io.IOException;

/**
 * @author lnsane
 */
@Service
public class DownloadServiceImpl implements DownloadService {
    private final static Logger log = LoggerFactory.getLogger(DownloadServiceImpl.class);
    @Autowired
    private OrderService orderService;
    @Override
    public void downloadOne(Order order, Channel channel, Message message) {
        log.info("进入获取报告第一个环节正在处理中");
        this.downloadApiOne(order, channel, message);
        log.info(order.toString());
        log.info("第一个处理报告环节处理完毕");
    }

    @Override
    public void downloadTwo(Order order, Channel channel, Message message) {
        log.info("进入获取报告第二个环节正在处理中");
        this.downloadApiTwo(order, channel, message);
        log.info(order.toString());
        log.info("第二个环节处理完毕");
    }

    @Transactional
    public void downloadApiOne(Order order, Channel channel, Message message) {
//        ThreadUtil.safeSleep(5000);
        order.setState(4);
        orderService.updateById(order);
    }

    @Transactional
    public void downloadApiTwo(Order order, Channel channel, Message message) {
//        ThreadUtil.safeSleep(5000);
        order.setState(5);
        orderService.updateById(order);
        TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronization() {
            @Override
            public void afterCommit() {
                try {
                    channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
