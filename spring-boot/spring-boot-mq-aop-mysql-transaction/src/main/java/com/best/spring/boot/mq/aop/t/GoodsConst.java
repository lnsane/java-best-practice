package com.best.spring.boot.mq.aop.t;

/**
 * @author 王存露
 * @date 2021/4/2
 */
public class GoodsConst {

    /**
     * 商品延迟交换机
     */
    public static final String SYNC_AMAZON_GOODS_DELAY_EXCHANGE_NAME = "SYNC_AMAZON_GOODS_DELAY_EXCHANGE_NAME";
    /**
     * 亚马逊同步商品延迟队列
     */
    public static final String SYNC_AMAZON_GOODS_DELAY_QUEUE_NAME = "SYNC_AMAZON_GOODS_DELAY_QUEUE_NAME";
    /**
     * 亚马逊同步商品处理队列KEY
     */
    public static final String SYNC_AMAZON_GOODS_DELAY_QUEUE_ROUTING_KEY = "SYNC_AMAZON_GOODS_DELAY_DELAY_QUEUE_ROUTING_KEY";

    /**
     * 亚马逊同步商品死信交换机
     */
    public static final String SYNC_AMAZON_GOODS_DEAD_EXCHANGE_NAME = "SYNC_AMAZON_GOODS_DEAD_EXCHANGE_NAME";

    /**
     * 亚马逊同步商品死信队列
     */
    public static final String SYNC_AMAZON_GOODS_DEAD_QUEUE_NAME = "SYNC_AMAZON_GOODS_DEAD_QUEUE_NAME";

    /**
     * 亚马逊同步商品死信KEY
     */
    public static final String SYNC_AMAZON_GOODS_DEAD_QUEUE_NAME_ROUTING_KEY = "SYNC_AMAZON_GOODS_DEAD_QUEUE_NAME_ROUTING_KEY";


}
