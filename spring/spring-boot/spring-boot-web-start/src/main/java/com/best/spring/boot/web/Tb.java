package com.best.spring.boot.web;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class Tb  implements InitializingBean , BeanFactoryAware , BeanNameAware , ApplicationContextAware  , DisposableBean {

    public  String getS() {
        return s;
    }

    public  void setS(String s) {
        this.s = s;
    }

    private  String s;


    public Tb() {
        s = "1";
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("BeanFactoryAware");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("BeanNameAware");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("ApplicationContextAware");
    }



    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean");
    }


}
