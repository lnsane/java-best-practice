package com.best.spring.rabbitmq.config;

import com.best.spring.rabbitmq.GoodsConst;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 王存露
 */
@Configuration
public class RabbitMqConfig {
    @Autowired
    public ConnectionFactory connectionFactory;

    /**
     * 延迟交换机初始化
     */
    @Bean(name = GoodsConst.SYNC_AMAZON_GOODS_DELAY_EXCHANGE_NAME)
    public DirectExchange goodsDelayExchangeName() {
        return ExchangeBuilder.directExchange(GoodsConst.SYNC_AMAZON_GOODS_DELAY_EXCHANGE_NAME)
                .durable(true)
                .build();
    }


    /**
     * 商品延迟队列
     */
    @Bean(name = GoodsConst.SYNC_AMAZON_GOODS_DELAY_QUEUE_NAME)
    public Queue goodsDelayQueueName() {
        return QueueBuilder.durable(GoodsConst.SYNC_AMAZON_GOODS_DELAY_QUEUE_NAME)
                .deadLetterExchange(GoodsConst.SYNC_AMAZON_GOODS_DEAD_EXCHANGE_NAME)
                .deadLetterRoutingKey(GoodsConst.SYNC_AMAZON_GOODS_DEAD_QUEUE_NAME_ROUTING_KEY)
                .build();
    }

    /**
     * 商品死信交换机
     */
    @Bean(GoodsConst.SYNC_AMAZON_GOODS_DEAD_EXCHANGE_NAME)
    public DirectExchange goodsDeadExchangeName() {
        return ExchangeBuilder.directExchange(GoodsConst.SYNC_AMAZON_GOODS_DEAD_EXCHANGE_NAME)
                .durable(true)
                .build();
    }

    /**
     * 商品死信队列
     */
    @Bean(GoodsConst.SYNC_AMAZON_GOODS_DEAD_QUEUE_NAME)
    public Queue goodsDeadQueueName() {
        return QueueBuilder.durable(GoodsConst.SYNC_AMAZON_GOODS_DEAD_QUEUE_NAME)
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
                    DirectExchange exchange) {
        return BindingBuilder.bind(queue)
                .to(exchange)
                .with(GoodsConst.SYNC_AMAZON_GOODS_DELAY_QUEUE_ROUTING_KEY);
    }

    /**
     * 商品死信队列绑定死信交换机
     */
    @Bean
    public Binding deadLetterBindingA(
            @Qualifier(GoodsConst.SYNC_AMAZON_GOODS_DEAD_QUEUE_NAME)
                    Queue queue,
            @Qualifier(GoodsConst.SYNC_AMAZON_GOODS_DEAD_EXCHANGE_NAME)
                    DirectExchange exchange) {
        return BindingBuilder.bind(queue)
                .to(exchange)
                .with(GoodsConst.SYNC_AMAZON_GOODS_DEAD_QUEUE_NAME_ROUTING_KEY);
    }

}
