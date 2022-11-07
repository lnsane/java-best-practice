package com.best.spring.boot.sync.event.trancation.event;

import org.springframework.context.ApplicationEvent;

import java.time.Clock;

public class GoodsEventListener extends ApplicationEvent {
    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    private String goodsId;

    public GoodsEventListener(Object source, String goodsId) {
        super(source);
        this.goodsId = goodsId;
    }

    public GoodsEventListener(Object source, Clock clock) {
        super(source, clock);
    }

    @Override
    public String toString() {
        return "GoodsEventListener{" +
                "goodsId='" + goodsId + '\'' +
                '}';
    }
}
