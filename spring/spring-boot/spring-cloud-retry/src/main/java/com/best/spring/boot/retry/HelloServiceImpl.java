package com.best.spring.boot.retry;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {

    @Override
    @Retryable(recover = "helloFail",maxAttempts=3, backoff=@Backoff(delay=100, maxDelay=500) ,value = ArithmeticException.class)
    public String hello() {
        if (1 / 0 == 9) {

        }
        return "hello";
    }

    @Recover
    public String helloFail(ArithmeticException e){
        return "fail";
    }
}
