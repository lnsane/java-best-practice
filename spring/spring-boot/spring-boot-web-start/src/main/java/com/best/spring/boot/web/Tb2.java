package com.best.spring.boot.web;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class Tb2 implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.contains("tb")) {
            System.out.println("postProcessBeforeInitialization");
            Tb tb = new Tb();
            tb.setS("11111111");
            return tb;
        }

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.contains("tb")) {
            System.out.println("postProcessAfterInitialization");
        }
        return bean;
    }

}
