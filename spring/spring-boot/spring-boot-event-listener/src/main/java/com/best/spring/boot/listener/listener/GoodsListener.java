package com.best.spring.boot.listener.listener;

import com.best.spring.boot.listener.event.GoodsEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class GoodsListener {
    Logger logger = LoggerFactory.getLogger(GoodsListener.class);

    @Async
    @EventListener(classes = GoodsEventListener.class)
    public void goodsListenerEvent(GoodsEventListener goodsEventListener) {
        logger.info(goodsEventListener.toString());
    }

}
