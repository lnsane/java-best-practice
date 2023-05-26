package com.best.spring.cloud.openfeign.config;

import feign.codec.Decoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenFeignConfigure {

    @Bean
    public Decoder openfeignErrorDecode() {
        return new OpenfeignDecoder();
    }
}
