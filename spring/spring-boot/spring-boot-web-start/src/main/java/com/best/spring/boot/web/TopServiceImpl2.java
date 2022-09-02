package com.best.spring.boot.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author CunLu Wang
 * @since 2022/8/29
 */
@Service(value = "sms")
public class TopServiceImpl2 extends TopService {
    @Autowired
    private Hello hello;


    public TopService build(String name){
        this.setAlias(name);
        this.setPkName(hello.pk(name));
        this.init();
        return this;
    }
    @Override
    public void change() {
        System.out.println(this.getPp());
    }
}
