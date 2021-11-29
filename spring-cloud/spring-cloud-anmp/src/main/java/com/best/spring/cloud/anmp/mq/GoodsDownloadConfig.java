package com.best.spring.cloud.anmp.mq;

import com.best.spring.cloud.anmp.DownloadConst;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lnsane
 */
@Configuration
public class GoodsDownloadConfig {

    /**
     * 延迟交换机初始化
     */
    @Bean(name = DownloadConst.AMAZON_GOODS_DOWNLOAD_DELAY_EXCHANGE)
    public CustomExchange goodsDelayExchangeName() {
        Map<String, Object> args = new HashMap<>();
        args.put("x-delayed-type", "direct");
        return new CustomExchange(DownloadConst.AMAZON_GOODS_DOWNLOAD_DELAY_EXCHANGE, "x-delayed-message", true, false, args);
    }


    /**
     * 商品延迟队列
     */
    @Bean(name = DownloadConst.AMAZON_GOODS_DOWNLOAD_DELAY_QUEUE)
    public Queue goodsDelayQueueName() {
        return QueueBuilder.durable(DownloadConst.AMAZON_GOODS_DOWNLOAD_DELAY_QUEUE)
                .build();
    }



    /**
     * 延迟队列绑定延迟交换机
     */
    @Bean
    public Binding downloadDelayBindingA(
            @Qualifier(DownloadConst.AMAZON_GOODS_DOWNLOAD_DELAY_QUEUE)
                    Queue queue,
            @Qualifier(DownloadConst.AMAZON_GOODS_DOWNLOAD_DELAY_EXCHANGE)
                    CustomExchange exchange) {
        return BindingBuilder.bind(queue)
                .to(exchange)
                .with(DownloadConst.AMAZON_GOODS_DOWNLOAD_DELAY_ROUTING_KEY)
                .noargs();
    }
}
