package com.best.spring.boot.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

/**
 * @author CunLu Wang
 * @since 2022/8/22
 */
@RestController
@Slf4j
public class DemoController {


    @GetMapping("/demo")
    public void demo(){

        this.demo2();
    }

    @GetMapping("/demo2")
    public void demo3(){
        while (true){
        }
    }

    public  void demo2(){
        System.out.println("start");

        try {
            TimeUnit.DAYS.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("end");

    }

    public static void main(String[] args) {
        System.out.println(new BigDecimal("1000.100").stripTrailingZeros());
    }
}
