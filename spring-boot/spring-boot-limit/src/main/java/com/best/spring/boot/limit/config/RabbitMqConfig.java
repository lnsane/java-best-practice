package com.best.spring.boot.limit.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.RabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 王存露
 */
@Configuration
public class RabbitMqConfig {
    @Autowired
    public ConnectionFactory connectionFactory;
    @Bean
    public RabbitListenerContainerFactory<SimpleMessageListenerContainer> prefetchTenRabbitListenerContainerFactory(ConnectionFactory rabbitConnectionFactory) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(rabbitConnectionFactory);
        factory.setPrefetchCount(1);
        return factory;
    }
    @Bean
    Queue queue() {
        return QueueBuilder.durable("queue1")
                           .build();
    }

    @Bean

    Queue queue2() {
        Map<String, Object> hashMap = new HashMap<>();
        hashMap.put("x-max-priority", 100);
        return QueueBuilder.durable("queue2")
                .withArguments(hashMap)
                .build();
    }

    @Bean
    FanoutExchange exchange() {
        return ExchangeBuilder.fanoutExchange("exp1")
                              .durable(true)
                              .build();
    }

    @Bean
    Binding binding(Queue queue,
                    FanoutExchange exchange) {
        return BindingBuilder.bind(queue)
                .to(exchange);
    }

    @Bean
    Binding binding2(Queue queue2,
                     FanoutExchange exchange) {
        return BindingBuilder.bind(queue2)
                .to(exchange);
    }

    @Bean
    public MessageConverter jsonMessageConverterPut() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(jsonMessageConverterPut());
        return template;
    }

}
