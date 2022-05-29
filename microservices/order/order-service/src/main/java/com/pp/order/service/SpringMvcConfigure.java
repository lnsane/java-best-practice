package com.pp.order.service;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SpringMvcConfigure implements WebMvcConfigurer {


    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SpringMvcInterceptor());
    }
}