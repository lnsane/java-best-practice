package com.best.spring.boot.limit.config;

import com.github.onblog.commoon.entity.RateLimiterRule;
import com.github.onblog.commoon.entity.RateLimiterRuleBuilder;
import com.github.onblog.core.limiter.RateLimiter;
import com.github.onblog.core.limiter.RateLimiterFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

/**
 * @author 王存露
 */
@Component
public class LimitConfig {
    @PostConstruct
    public RateLimiter register() {
        RateLimiterRule rateLimiterRule = new RateLimiterRuleBuilder().setId("limiter") //ID很重要，对应注解@Limiter中的value
                                                                      .setLimit(2)
                                                                      .setPeriod(10)
                                                                      .setUnit(TimeUnit.SECONDS)
                                                                      .build();
        return RateLimiterFactory.of(rateLimiterRule);
    }


}
