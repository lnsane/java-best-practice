package com.best.spring.boot.resilience4j;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {
    private final String BACKEND = "backendB";

    private final static Logger log = LoggerFactory.getLogger(HelloServiceImpl.class);

    @Override
    @CircuitBreaker(name = BACKEND, fallbackMethod = "fallback")
    @RateLimiter(name = BACKEND)
    public String hello() {
        log.info("hello world");
        return "null";
    }

    public String fallback(Exception e) {
        log.info("fallback");
        return "fallback";
    }
}
