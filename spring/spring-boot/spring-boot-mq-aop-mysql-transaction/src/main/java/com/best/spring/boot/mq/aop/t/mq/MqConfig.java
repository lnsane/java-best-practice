package com.best.spring.boot.mq.aop.t.mq;

import com.best.spring.boot.mq.aop.t.GoodsConst;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lnsane
 */
@Configuration
public class MqConfig {
    @Autowired
    public ConnectionFactory connectionFactory;

    /**
     * 延迟交换机初始化
     */
    @Bean(name = GoodsConst.SYNC_AMAZON_GOODS_DELAY_EXCHANGE_NAME)
    public CustomExchange goodsDelayExchangeName() {
        Map<String, Object> args = new HashMap<>();
        args.put("x-delayed-type", "direct");
        return new CustomExchange(GoodsConst.SYNC_AMAZON_GOODS_DELAY_EXCHANGE_NAME, "x-delayed-message", true, false, args);
    }


    /**
     * 商品延迟队列
     */
    @Bean(name = GoodsConst.SYNC_AMAZON_GOODS_DELAY_QUEUE_NAME)
    public Queue goodsDelayQueueName() {
        return QueueBuilder.durable(GoodsConst.SYNC_AMAZON_GOODS_DELAY_QUEUE_NAME)
                .build();
    }


    /**
     * 延迟队列绑定延迟交换机
     */
    @Bean
    public Binding delayBindingA(
            @Qualifier(GoodsConst.SYNC_AMAZON_GOODS_DELAY_QUEUE_NAME)
                    Queue queue,
            @Qualifier(GoodsConst.SYNC_AMAZON_GOODS_DELAY_EXCHANGE_NAME)
                    CustomExchange exchange) {
        return BindingBuilder.bind(queue)
                .to(exchange)
                .with(GoodsConst.SYNC_AMAZON_GOODS_DELAY_QUEUE_ROUTING_KEY)
                .noargs();
    }


}
