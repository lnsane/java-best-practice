package com.best.spring.boot.sync.event.trancation.controller;

import com.best.spring.boot.sync.event.trancation.event.GoodsEventListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @GetMapping("/")
    public void test(@RequestParam("goodsId") String goodsId) {
        applicationEventPublisher.publishEvent(new GoodsEventListener(this, goodsId));
    }
}
