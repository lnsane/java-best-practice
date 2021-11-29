package com.best.spring.cloud.anmp;

import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author lnsane
 */
@Component
public class MqConsume {

    private final static String key = "Puting";
    private final static Logger log = LoggerFactory.getLogger(MqConsume.class);

    @RabbitListener(queues = GoodsConst.SYNC_AMAZON_GOODS_DELAY_QUEUE_NAME,concurrency = "5")
    public void consume(String msg, Channel channel, Message message) {
        if (1 / 0 == 0 ) {

        }
//        RLock lock = redissonClient.getFairLock(key);
//        try {
//            lock.lock(120, TimeUnit.SECONDS);
//            log.info("当前 msg ：{} 获取锁",msg);
//            Order order = BeanUtil.toBean(JSONUtil.parse(msg), Order.class);
//            Order orderCopy  = new Order();
//            BeanUtil.copyProperties(order,orderCopy);
//            LocalThread.set(orderCopy);
//            azom.put(order, channel, message);
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                log.info("当前的消息是 ： {} 释放锁 ", msg);
//                lock.unlock();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
    }
}
