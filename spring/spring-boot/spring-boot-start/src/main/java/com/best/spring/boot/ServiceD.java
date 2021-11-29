package com.best.spring.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceD {

    private ServiceC serviceC;

    @Autowired
    public void setServiceC(ServiceC serviceC) {
        this.serviceC = serviceC;
    }

    public void setServiceB() {
        serviceC.setServiceB();
    }
}
