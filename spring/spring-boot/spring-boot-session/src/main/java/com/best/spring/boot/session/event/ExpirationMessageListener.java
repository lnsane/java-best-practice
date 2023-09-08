package com.best.spring.boot.session.event;

/**
 * @author CunLu Wang
 * @since 2023/8/28
 */
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

@Component
public class ExpirationMessageListener implements MessageListener {

    @Override
    public void onMessage(Message message, byte[] pattern) {
        // 获取过期键的名称
        String expiredKey = message.toString();

        // 在这里编写处理过期事件的逻辑
        System.out.println("Key expired: " + expiredKey);
    }
}
