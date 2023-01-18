package com.best.spring.boot.kafka.contoller;

import cn.hutool.core.util.IdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * @author 王存露
 */
@RestController
public class TestController {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @GetMapping(value = "/")
    public void test() throws ExecutionException, InterruptedException {
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
            kafkaTemplate.send("topicName","123", "some string value "+ uuid).get();
            i--;
        }
    }
}
