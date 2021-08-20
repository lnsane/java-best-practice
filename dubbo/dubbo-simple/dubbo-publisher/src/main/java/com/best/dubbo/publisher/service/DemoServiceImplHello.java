package com.best.dubbo.publisher.service;

import com.best.dubbo.service.HelloDubboService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Value;

@DubboService(version = "${demo.service.version}")
public class DemoServiceImplHello implements HelloDubboService {
    @Value("${spring.application.name}")
    private String applicationName;

    @Override
    public String sayHello(String name) {
        return "hello " + name + " by " + applicationName;
    }

}
