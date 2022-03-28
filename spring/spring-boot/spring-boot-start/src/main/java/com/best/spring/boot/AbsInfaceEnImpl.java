package com.best.spring.boot;

import org.springframework.stereotype.Service;

@Service
public class AbsInfaceEnImpl implements AbsInface {
    @Override
    public boolean sayHello() {
        System.out.println("你好");
        return false;
    }
}
