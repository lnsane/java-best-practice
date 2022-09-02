package com.best.spring.boot.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * @author CunLu Wang
 * @since 2022/8/29
 */
@Service
public class TopServiceImpl extends TopService {
    private final Hello hello;

    public TopServiceImpl(Hello hello) {
        this.hello = hello;
    }

    @Override
    public void change() {

    }
}
