package com.spring.boot.logbook.controller;

/**
 * @author CunLu Wang
 * @since 2023/7/5
 */
public class HelloBody {
    public String getHello() {
        return hello;
    }

    public void setHello(String hello) {
        this.hello = hello;
    }

    private String hello;
}
