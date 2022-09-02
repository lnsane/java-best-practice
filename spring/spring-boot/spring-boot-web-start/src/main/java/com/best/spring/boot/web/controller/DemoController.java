package com.best.spring.boot.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

/**
 * @author CunLu Wang
 * @since 2022/8/22
 */
@RestController
public class DemoController {


    @GetMapping("/demo")
    public void demo(){
        this.demo2();
    }

    public synchronized void demo2(){
        System.out.println("start");

        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("end");

    }

    public static void main(String[] args) {
        System.out.println(new BigDecimal("1000.100").stripTrailingZeros());
    }
}
