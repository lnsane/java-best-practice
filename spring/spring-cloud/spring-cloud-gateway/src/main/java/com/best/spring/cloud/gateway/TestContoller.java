package com.best.spring.cloud.gateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author CunLu Wang
 * @since 2023/5/25
 */
@RestController
public class TestContoller {
    @GetMapping(value = "/hello")
    public void hello(){

    }
}
