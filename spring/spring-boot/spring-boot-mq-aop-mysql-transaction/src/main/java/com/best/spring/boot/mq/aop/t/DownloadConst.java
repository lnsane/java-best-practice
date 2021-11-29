package com.best.spring.boot.mq.aop.t;

/**
 * @author 王存露
 * @date 2021/4/2
 */
public class DownloadConst {

    /**
     * 获取商品报告延迟交换机
     */
    public static final String AMAZON_GOODS_DOWNLOAD_DELAY_EXCHANGE = "amazon_goods_download_delay_exchange";
    /**
     * 亚马逊获取商品报告延迟队列
     */
    public static final String AMAZON_GOODS_DOWNLOAD_DELAY_QUEUE = "amazon_goods_download_delay_queue";
    /**
     * 亚马逊获取商品报告处理队列KEY
     */
    public static final String AMAZON_GOODS_DOWNLOAD_DELAY_ROUTING_KEY = "amazon_goods_download_delay_routing_key";


}
