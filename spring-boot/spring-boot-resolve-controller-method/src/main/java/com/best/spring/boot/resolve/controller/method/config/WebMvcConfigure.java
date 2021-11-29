package com.best.spring.boot.resolve.controller.method.config;

import com.best.spring.boot.resolve.controller.method.web.resolve.CoustomWebControllerResolve;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @author lnsane
 */
@Configuration
@EnableWebMvc
public class WebMvcConfigure implements WebMvcConfigurer {
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new CoustomWebControllerResolve());
    }
}
