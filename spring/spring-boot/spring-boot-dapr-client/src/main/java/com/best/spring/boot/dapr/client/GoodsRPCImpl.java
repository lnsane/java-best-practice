package com.best.spring.boot.dapr.client;

import io.dapr.client.DaprClient;
import io.dapr.client.domain.HttpExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author CunLu Wang
 * @since 2022/7/27
 */
@Service
public class GoodsRPCImpl implements GoodsRPC {
    @Autowired
    private DaprClient daprClient;

    @Override
    public Hello hello() {
        return  daprClient.invokeMethod(SERVICE_ID,
                Thread.currentThread().getStackTrace()[1].getMethodName(), null, HttpExtension.GET, null,
                Hello.class).block();
    }
}
