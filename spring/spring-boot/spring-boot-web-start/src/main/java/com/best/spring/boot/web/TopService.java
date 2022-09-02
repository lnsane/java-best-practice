package com.best.spring.boot.web;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author CunLu Wang
 * @since 2022/8/29
 */
@Data
public abstract class TopService {
    @Autowired
    private Hello hello;
    private String alias;
    private String pkName;
    private String pp;
    public abstract void change();

    public void init(){
        this.pp = hello.pk("1");
    }
}
