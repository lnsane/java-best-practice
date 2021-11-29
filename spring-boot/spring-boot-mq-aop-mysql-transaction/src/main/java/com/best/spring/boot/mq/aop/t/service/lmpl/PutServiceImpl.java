package com.best.spring.boot.mq.aop.t.service.lmpl;

import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.json.JSONUtil;
import com.best.spring.boot.mq.aop.t.DownloadConst;
import com.best.spring.boot.mq.aop.t.model.Order;
import com.best.spring.boot.mq.aop.t.service.OrderService;
import com.best.spring.boot.mq.aop.t.service.PutService;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
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
public class PutServiceImpl implements PutService {
    private final static Logger log = LoggerFactory.getLogger(PutServiceImpl.class);
    @Autowired
    private AmqpTemplate amqpTemplate;

    @Autowired
    private OrderService orderService;

    //1 -> 未上架  2 - > 调用上传亚马逊创建文档完毕
    //3 -> 上传完毕 4 -> 调用下载亚马逊报告摘要完毕
    //5 -> 上架成功 6 - > 异常
    @Override
    public void putOne(Order msg, Channel channel, Message message) {
        log.info("进入上架第一个环节正在处理中");
        this.putApiOne(msg, channel, message);
        log.info(msg.toString());
        log.info("第一个环节处理完毕");
    }

    @Override
    public void putTwo(Order mes, Channel channel, Message message) {
        log.info("进入上架第二个环节正在处理中");
        this.putApiTwo(mes, channel, message);
        log.info(mes.toString());
        log.info("第二个环节处理完毕");
    }

    @Transactional
    public void putApiOne(Order order, Channel channel, Message message) {
        ThreadUtil.safeSleep(5000);
        order.setState(2);
        orderService.updateById(order);
    }

    @Transactional
    public void putApiTwo(Order order, Channel channel, Message message) {
        ThreadUtil.safeSleep(5000);
        order.setState(3);
        TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronization() {
            @Override
            public void afterCommit() {
                try {
                    channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
                    MessageProperties props = new MessageProperties();
//                    props.setDelay(0);
                    Message message2 = new Message(JSONUtil.toJsonStr(order).getBytes(), props);
                    amqpTemplate.convertAndSend(DownloadConst.AMAZON_GOODS_DOWNLOAD_DELAY_EXCHANGE,
                            DownloadConst.AMAZON_GOODS_DOWNLOAD_DELAY_ROUTING_KEY, message2);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        String methodName = ThreadUtil.getStackTrace()[2].getMethodName();
        System.out.println(methodName);
        orderService.updateById(order);

//        throw new OrderException();
    }
}
