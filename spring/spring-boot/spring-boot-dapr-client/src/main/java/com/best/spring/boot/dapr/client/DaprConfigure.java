package com.best.spring.boot.dapr.client;

import io.dapr.client.DaprClient;
import io.dapr.client.DaprClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author CunLu Wang
 * @since 2022/7/27
 */
@Configuration
public class DaprConfigure {
    @Bean
    public DaprClient daprClient(){
        return (new DaprClientBuilder()).build();
    }
}
