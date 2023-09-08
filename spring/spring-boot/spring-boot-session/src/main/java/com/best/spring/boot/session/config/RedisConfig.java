package com.best.spring.boot.session.config;

import com.best.spring.boot.session.RedisLienter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;

/**
 * @author 王存露
 */
@Configuration
public class RedisConfig {
    private final RedisConnectionFactory redisConnectionFactory;
    @Value("${spring.redis.database}")
    private String redisDatabase;
    @Autowired
    public RedisConfig(RedisConnectionFactory redisConnectionFactory) {
        this.redisConnectionFactory = redisConnectionFactory;
    }

    /**
     * <h2>配置消息监听器</h2>
     * */
    @Bean
    public RedisLienter listener() {
        return new RedisLienter();
    }

    /**
     * <h2>配置 发布/订阅 的 Topic</h2>
     * */
    @Bean
    public ChannelTopic channelTopic() {
        return new ChannelTopic("__keyevent@"+redisDatabase+"__:expired");
    }

    /**
     * <h2>配置 ChannelName 的模式匹配</h2>
     * */
    @Bean
    public PatternTopic patternTopic() {
        return new PatternTopic("/__keyevent@"+redisDatabase+"__:expired/*");
    }

    /**
     * <h2>将消息监听器绑定到消息容器</h2>
     * */
    @Bean
    public RedisMessageListenerContainer messageListenerContainer() {

        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(redisConnectionFactory);

        // 可以修改成 patternTopic, 看一看 MessageListener 中监听的数据
        container.addMessageListener(listener(), channelTopic());
        return container;
    }
}
