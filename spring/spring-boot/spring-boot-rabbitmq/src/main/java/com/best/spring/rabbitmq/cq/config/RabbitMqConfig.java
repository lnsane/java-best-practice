package com.best.spring.rabbitmq.cq.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 王存露
 */
@Configuration
public class RabbitMqConfig {
    @Autowired
    public ConnectionFactory connectionFactory;

    @Bean
    Queue queue() {
        return new Queue("queue1",true,true,false);
    }

    @Bean

    Queue queue2() {
        return QueueBuilder.durable("queue2")
                           .build();
    }

    @Bean
    FanoutExchange exchange() {
        return ExchangeBuilder.fanoutExchange("exp1")
                              .durable(true)
                              .build();
    }

    @Bean
    Binding binding( Queue queue,
                    FanoutExchange exchange){
        return BindingBuilder.bind(queue)
                             .to(exchange);
    }

    @Bean
    Binding binding2(Queue queue2,
                    FanoutExchange exchange){
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
