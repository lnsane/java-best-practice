package com.best.spring.boot.mq.aop.t.consume;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.json.JSONUtil;
import com.best.spring.boot.mq.aop.t.DownloadConst;
import com.best.spring.boot.mq.aop.t.content.LocalThread;
import com.best.spring.boot.mq.aop.t.model.Order;
import com.best.spring.boot.mq.aop.t.service.Azom;
import com.rabbitmq.client.Channel;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author lnsane
 */
@Component
public class DownloadConsume {
    private final static String key = "Download";
    private final static Logger log = LoggerFactory.getLogger(DownloadConsume.class);
    @Autowired
    private Azom azom;
    @Autowired
    private RedissonClient redissonClient;

    @RabbitListener(queues = DownloadConst.AMAZON_GOODS_DOWNLOAD_DELAY_QUEUE,concurrency = "5",ackMode = "MANUAL")
    public void consume(String msg, Channel channel, Message message) {
        RLock lock = redissonClient.getFairLock(key);
        try {
            lock.lock(120, TimeUnit.SECONDS);
            log.info("当前 msg ：{} 获取锁",msg);
            Order order = BeanUtil.toBean(JSONUtil.parse(msg), Order.class);
            Order orderCopy  = new Order();
            BeanUtil.copyProperties(order,orderCopy);
            LocalThread.set(orderCopy);
            azom.download(order, channel, message);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                log.info("当前的消息是 ： {} 释放锁 ", msg);
                lock.unlock();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
//        Order order = BeanUtil.toBean(JSONUtil.parse(msg), Order.class);
//        azom.download(order, channel, message);
    }
}
