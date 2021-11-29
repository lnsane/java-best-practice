package com.best.spring.boot.web.config;

import com.best.spring.boot.web.interceptor.FirstInterceptor;
import com.best.spring.boot.web.interceptor.SecInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 王存露
 */
@Component
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new FirstInterceptor());
        registry.addInterceptor(new SecInterceptor());
    }
}
