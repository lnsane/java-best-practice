package com.best.dubbo.comsumer;

import com.best.dubbo.service.HelloDubboService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@EnableAutoConfiguration
@RestController
public class DubboConsumerApplication {
    @DubboReference(version = "${demo.service.version}")
    private HelloDubboService helloDubboService;

    public static void main(String[] args) {
        SpringApplication.run(DubboConsumerApplication.class, args);
    }


    @GetMapping(value = "/")
    public String sayHello() {
        List<String> a = List.of("1").stream().toList();
        List<String> strings1 = helloDubboService.copyList(a);
        System.out.println(strings1);

        return helloDubboService.sayHello(null);
    }

}
