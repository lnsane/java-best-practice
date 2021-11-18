package com.best.spring.boot;

import org.springframework.stereotype.Component;

@Component
public class ServiceB {

    private ServiceA serviceA;

    public ServiceB(ServiceA serviceA) {
        this.serviceA = serviceA;
    }

    public void setServiceB() {
        serviceA.setServiceB();
        System.out.println("b");
    }
}
