package com.best.spring.boot.web;

import org.springframework.stereotype.Component;

/**
 * @author CunLu Wang
 * @since 2022/8/29
 */
@Component
public class Hello {
    public String pk(String alias){
        return alias.concat("122");
    }
}
