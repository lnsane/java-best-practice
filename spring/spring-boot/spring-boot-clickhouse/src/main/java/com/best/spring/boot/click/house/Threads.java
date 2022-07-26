package com.best.spring.boot.click.house;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Threads implements Runnable{
    @Autowired
    private UserMapper userMapper;
    @Override
    public void run() {
        List<User> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {

        }
    }
}
