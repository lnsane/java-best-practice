package com.spring.boot.rocktmq.demo;

import cn.hutool.core.lang.Console;
import cn.hutool.core.thread.ConcurrencyTester;
import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.core.util.RandomUtil;
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

        // Send request in async mode and receive a reply of User type.
        ConcurrencyTester tester = ThreadUtil.concurrencyTest(1, () -> {
            Data dataModel = new Data();
            Integer integer = Delay.calculateDefault(59, dataModel);
            rocketMQTemplate.sendAndReceive(userTopic, dataModel, new RocketMQLocalRequestCallback<Data>() {
                @Override
                public void onSuccess(Data message) {
                    System.out.printf("send user object and receive %s %n", message.toString());
                }

                @Override
                public void onException(Throwable e) {
                }
            }, -1,integer);
            // 测试的逻辑内容
            long delay = RandomUtil.randomLong(100, 1000);
            ThreadUtil.sleep(delay);
            Console.log("{} test finished, delay: {}", Thread.currentThread().getName(), delay);
        });

        // 获取总的执行时间，单位毫秒
        Console.log(tester.getInterval());

    }

}
