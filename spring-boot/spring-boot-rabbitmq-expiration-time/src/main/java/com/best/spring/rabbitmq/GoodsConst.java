package com.best.spring.rabbitmq;

/**
 * @author 王存露
 * @date 2021/4/2
 */
public class GoodsConst {
    /**
     * 配置您申请聚合数据调用汇率计算的KEY
     */
    public static final String APPKEY = "f4e57eb8bb12d6d572c560ec38426ca8";
    /**
     * 请求地址
     */
    public static final String REQUEST_URL = "http://web.juhe.cn:8080/finance/exchange/rmbquot";

    /**
     * 商品5点详情的分割图
     */
    public static final String SEPARATOR = "%f4e57eb8bb%";
    /**
     * 商品延迟交换机
     */
    public static final String GOODS_DELAY_EXCHANGE_NAME = "GOODS_DELAY_EXCHANGE_NAME";
    /**
     * 商品延迟队列
     */
    public static final String GOODS_DELAY_QUEUE_NAME = "GOODS_DELAY_QUEUE_NAME";
    /**
     * 商品处理队列KEY
     */
    public static final String GOODS_DELAY_QUEUE_ROUTING_KEY = "GOODS_DELAY_DELAY_QUEUE_ROUTING_KEY";

    /**
     * 商品死信交换机
     */
    public static final String GOODS_DEAD_EXCHANGE_NAME = "GOODS_DEAD_EXCHANGE_NAME";

    /**
     * 商品死信队列
     */
    public static final String GOODS_DEAD_QUEUE_NAME = "GOODS_DEAD_QUEUE_NAME";

    /**
     * 商品死信KEY
     */
    public static final String GOODS_DEAD_QUEUE_NAME_ROUTING_KEY = "GOODS_DEAD_QUEUE_NAME_ROUTING_KEY";


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


    /**
     * Upc 占位符
     */
    public static final String UPC_PLACEHOLDER = "G";

}
