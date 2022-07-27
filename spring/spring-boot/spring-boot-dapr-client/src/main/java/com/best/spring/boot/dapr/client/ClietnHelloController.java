package com.best.spring.boot.dapr.client;

import io.dapr.client.DaprClient;
import io.dapr.client.DaprClientBuilder;
import io.dapr.client.domain.HttpExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author CunLu Wang
 * @since 2022/7/27
 */
@RestController
public class ClietnHelloController {

    @Autowired
    private GoodsRPC goodsRPC;



    @GetMapping("dapr")
    public Hello hello(){
        return goodsRPC.hello();
    }
}
