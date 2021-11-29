package com.best.spring.boot.session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;

/**
 * @author 王存露
 */
public class RedisLienter implements MessageListener {
    private final static Logger log = LoggerFactory.getLogger(RedisLienter.class);
    @Override
    public void onMessage(Message message, byte[] pattern) {
        log.info("start");
    }
}
