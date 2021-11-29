package com.best.spring.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceC {

    private ServiceD serviceD;

    @Autowired
    public void setServiceD(ServiceD serviceD) {
        this.serviceD = serviceD;
    }

    public void setServiceB() {
        serviceD.setServiceB();
        System.out.println("b");
    }
}
