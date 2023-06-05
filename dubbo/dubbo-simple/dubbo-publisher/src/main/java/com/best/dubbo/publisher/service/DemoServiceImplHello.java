package com.best.dubbo.publisher.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.best.dubbo.service.HelloDubboService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@DubboService(version = "${demo.service.version}")
@RestController
public class DemoServiceImplHello implements HelloDubboService {
    @Value("${spring.application.name}")
    private String applicationName;

    @Override
    @SentinelResource(value = "sayHello", blockHandler = "exceptionHandler", fallback = "helloFallback")
    @GetMapping("/hello")
    public String sayHello(@RequestParam("name") String name) {
        return "hello " + name + " by " + applicationName;
    }

    @Override
    public List<String> copyList(List<String> list) {
        return list;
    }

    // Fallback 函数，函数签名与原函数一致或加一个 Throwable 类型的参数.
    public String helloFallback(String name) {
        return String.format("Halooooo %s", name);
    }

    // Block 异常处理函数，参数最后多一个 BlockException，其余与原函数一致.
    public String exceptionHandler(String name, BlockException ex) {
        // Do some log here.
        ex.printStackTrace();
        return "Oops, error occurred at " + name;
    }
}
