package com.best.spring.boot.sync.event.trancation.listener;

import com.best.spring.boot.sync.event.trancation.event.GoodsEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
public class GoodsListener {
    Logger logger = LoggerFactory.getLogger(GoodsListener.class);

    @Async
    @TransactionalEventListener(classes = GoodsEventListener.class)
    public void goodsListenerEvent(GoodsEventListener goodsEventListener) {
        logger.info(goodsEventListener.toString());
    }
}
