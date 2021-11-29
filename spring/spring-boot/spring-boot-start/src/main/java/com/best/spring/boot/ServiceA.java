package com.best.spring.boot;

import org.springframework.stereotype.Component;

@Component
public class ServiceA {
    private final ServiceC serviceC;

    public ServiceA(ServiceC servicec) {
        this.serviceC = servicec;
    }

    public void setServiceB() {
        serviceC.setServiceB();
        System.out.println("b");
    }

}
