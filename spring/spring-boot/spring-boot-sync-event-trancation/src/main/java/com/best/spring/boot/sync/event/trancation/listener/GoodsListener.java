package com.best.spring.boot.sync.event.trancation.listener;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.best.spring.boot.sync.event.trancation.event.GoodsEventListener;
import com.best.spring.boot.sync.event.trancation.model.Order;
import com.best.spring.boot.sync.event.trancation.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
public class GoodsListener {
    Logger logger = LoggerFactory.getLogger(GoodsListener.class);
    @Autowired
    private OrderService orderService;
    @TransactionalEventListener(classes = GoodsEventListener.class,fallbackExecution = true,phase = TransactionPhase.BEFORE_COMMIT)
    public void goodsListenerEvent(GoodsEventListener goodsEventListener) {
        logger.info(goodsEventListener.toString());
        String goodsId = goodsEventListener.getGoodsId();
        Order one = orderService.getOne(Wrappers.<Order>lambdaQuery().eq(Order::getId, goodsId));
        System.out.println(one);
        one.setState(2);
        orderService.update(one,Wrappers.<Order>lambdaQuery().eq(Order::getId, goodsId));
        logger.info("after");
    }
}
