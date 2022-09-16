package com.spring.boot.rocktmq.demo;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.json.JSONUtil;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.apache.rocketmq.spring.core.RocketMQLocalRequestCallback;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author CunLu Wang
 * @since 2022/9/16
 */
@Service
@RocketMQMessageListener(nameServer = "${demo.rocketmq.myNameServer}", topic = "${demo.rocketmq.topic.user}", consumerGroup = "user_consumer")
public class UserConsumer implements RocketMQListener<Data> {

    @Value("${demo.rocketmq.topic.user}")
    private String userTopic;


    @Resource
    private RocketMQTemplate rocketMQTemplate;

    @Override
    public void onMessage(Data message) {
//        System.out.printf("######## user_consumer received: %s ; age: %s ; name: %s \n", message, message.getUserAge(), message.getUserName());
        if (ObjectUtil.isNotNull(message)) {
            if (ObjectUtil.isNotNull(message.getRemainDelayTime())) {
                if (message.getRemainDelayTime() <= 0) {
                    System.out.println(JSONUtil.toJsonStr(message));
                } else {
                    System.out.println( "剩余秒 ：" + message.getRemainDelayTime());
                    Integer integer = Delay.calculateDefault(message.getRemainDelayTime(), message);
                    // Send request in async mode and receive a reply of User type.
                    rocketMQTemplate.sendAndReceive(userTopic, message, new RocketMQLocalRequestCallback<Data>() {
                        @Override
                        public void onSuccess(Data message) {
                            System.out.printf("send user object and receive %s %n", message.toString());
                        }

                        @Override
                        public void onException(Throwable e) {
                        }
                    }, -1,integer);
                }
            }
        }
    }

}
