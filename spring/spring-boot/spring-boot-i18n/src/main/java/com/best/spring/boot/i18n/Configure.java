package com.best.spring.boot.i18n;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

//@Component
public class Configure {
    @Bean
    public MessageSource messageSource(MessageSource messageSource) {
        return messageSource;
    }
}
