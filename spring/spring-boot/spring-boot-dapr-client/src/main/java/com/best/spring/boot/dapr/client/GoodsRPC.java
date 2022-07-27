package com.best.spring.boot.dapr.client;

import io.dapr.client.DaprClientBuilder;
import io.dapr.client.domain.HttpExtension;
import org.springframework.stereotype.Component;

/**
 * @author CunLu Wang
 * @since 2022/7/27
 */
public interface GoodsRPC {
    String SERVICE_ID = "invokedemo";
    Hello hello();
}
