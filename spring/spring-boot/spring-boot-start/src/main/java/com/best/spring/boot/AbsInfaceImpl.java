package com.best.spring.boot;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class AbsInfaceImpl implements AbsInface {
    @Override
    public boolean sayHello() {
        System.out.println("hello");
        return false;
    }
}
