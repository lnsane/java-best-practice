package com.best.spring.boot.dapr.client;

import io.dapr.client.DaprClientBuilder;
import io.dapr.client.domain.HttpExtension;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author CunLu Wang
 * @since 2022/7/27
 */
@Service
public class GoodsRPCImpl implements GoodsRPC {
    @Override
    public Hello hello() {
        return (new DaprClientBuilder()).build().invokeMethod(SERVICE_ID,
                Thread.currentThread().getStackTrace()[1].getMethodName(), null, HttpExtension.GET, null,
                Hello.class).block();
    }
}
