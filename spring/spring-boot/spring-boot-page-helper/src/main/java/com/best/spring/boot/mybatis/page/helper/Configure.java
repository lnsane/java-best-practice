package com.best.spring.boot.mybatis.page.helper;

import com.github.pagehelper.PageInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author CunLu Wang
 * @since 2022/8/24
 */
@Configuration
public class Configure {
    @Bean
    public PageInterceptor plugin(){
        return new PageInterceptor();
    }
}
