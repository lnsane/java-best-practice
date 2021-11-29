package com.best.spring.boot.kafka;

import cn.hutool.core.util.IdUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.support.GenericMessage;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SpringBootKafkaDemoTest {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

//    @Value("${kafka.topic.name}")
//    private String topicName;

//    @Test
    public void run() {
        int i = 1000000;
        while (true) {
            if (i < 0 ){
                break;
            }
            String uuid = IdUtil.fastUUID();
            Map<String, Object> headers = new HashMap<>();
            headers.put(KafkaHeaders.TOPIC, "topicName");
//        kafkaTemplate.send(new GenericMessage<>("student", headers));
            // use the below to send String values through kafka
            kafkaTemplate.send("topicName","123", "some string value "+ uuid);
            i--;
        }

    }

    @Test
    public void test() {

    }



}