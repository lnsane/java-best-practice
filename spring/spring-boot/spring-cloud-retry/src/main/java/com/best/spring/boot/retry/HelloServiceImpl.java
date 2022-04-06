package com.best.spring.boot.retry;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

@Service
public class HelloServiceImpl implements HelloService {


    @Override
    @Retryable(recover = "helloFail",maxAttempts=3, backoff=@Backoff(delay=100, maxDelay=500) ,value = ArithmeticException.class)
    public String hello() {
        return "hello";
    }

    public static void main(String[] args) throws InterruptedException {
         final BlockingQueue<Long> catalogs = new ArrayBlockingQueue<>(1000);
        System.out.println(catalogs.take());
    }
    @Recover
    public String helloFail(ArithmeticException e){
        return "fail";
    }
}
