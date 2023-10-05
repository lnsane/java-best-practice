package com.spring.boot.logbook;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @author CunLu Wang
 * @since 2023/7/5
 */
@Component
public class AService {
    Logger logger = LoggerFactory.getLogger(AService.class);
    @Async
    public Future<Integer> hello(){
        logger.info("你好");
        AsyncResult<Integer> result = new AsyncResult<>(1);
        return result;
    }
}
