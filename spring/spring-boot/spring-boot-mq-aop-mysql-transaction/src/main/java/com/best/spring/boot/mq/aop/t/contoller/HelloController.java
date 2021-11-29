package com.best.spring.boot.mq.aop.t.contoller;

import cn.hutool.json.JSONUtil;
import com.best.spring.boot.mq.aop.t.GoodsConst;
import com.best.spring.boot.mq.aop.t.model.Order;
import com.best.spring.boot.mq.aop.t.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author lnsane
 */
@RestController
public class HelloController {
    private final static Logger log = LoggerFactory.getLogger(HelloController.class);
    @Autowired
    private AmqpTemplate amqpTemplate;
    @Autowired
    private OrderService orderService;
    //1 -> 未上架  2 - > 调用上传亚马逊创建文档完毕
    //3 -> 上传完毕 4 -> 调用下载亚马逊报告摘要完毕
    //5 -> 上架成功 6 - > 异常
    @GetMapping
    public void hello(@RequestParam("time") Integer time) {
        log.info("进入 hello controller");
        Order order = new Order();
        order.setOrderName("");
        order.setState(1);
        order.setCreateTime(new Date());
        order.setUpdateTime(new Date());
        orderService.save(order);
        MessageProperties props = new MessageProperties();
        props.setDelay(time);
        Message message2 = new Message(JSONUtil.toJsonStr(order).getBytes(), props);
        amqpTemplate.convertAndSend(GoodsConst.SYNC_AMAZON_GOODS_DELAY_EXCHANGE_NAME,
                GoodsConst.SYNC_AMAZON_GOODS_DELAY_QUEUE_ROUTING_KEY, message2);
        log.info("完毕 hello controller");
    }
}
