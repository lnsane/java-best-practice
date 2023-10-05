package com.best.spring.cloud.gateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

/**
 * @author CunLu Wang
 * @since 2023/5/25
 */
@RestController
public class TestContoller {
    @GetMapping(value = "/hello")
    public HashMap<String,String> hello(ServerWebExchange exchange){
        return null;
    }
}
