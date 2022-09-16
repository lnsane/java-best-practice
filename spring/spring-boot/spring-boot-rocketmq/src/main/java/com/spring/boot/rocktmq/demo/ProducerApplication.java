package com.spring.boot.rocktmq.demo;

import org.apache.rocketmq.spring.core.RocketMQLocalRequestCallback;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author CunLu Wang
 * @since 2022/9/16
 */
@Component
public class ProducerApplication implements CommandLineRunner {

    @Resource
    private RocketMQTemplate rocketMQTemplate;

    @Value("${demo.rocketmq.topic.user}")
    private String userTopic;


    @Override
    public void run(String... args) throws Exception {

        int sec = 59;
        DataModel dataModel = new DataModel();
        Integer integer = DelayLevelCalculate.calculateDefault(59, dataModel);
        // Send request in async mode and receive a reply of User type.
        rocketMQTemplate.sendAndReceive(userTopic, dataModel, new RocketMQLocalRequestCallback<DataModel>() {
            @Override
            public void onSuccess(DataModel message) {
                System.out.printf("send user object and receive %s %n", message.toString());
            }

            @Override
            public void onException(Throwable e) {
                e.printStackTrace();
            }
        }, 5000,integer);
    }

}
