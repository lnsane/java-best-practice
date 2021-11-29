package com.best.spring.cloud.openfeign;

import cn.hutool.http.HttpRequest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringCloudOpenFeignDemoTest {

    @Test
    public void hello() {
        String body = HttpRequest.get("https://img.goten.com/Resources/GoodsImages//2020/202012/202012082306411178_57cbe17c-8024-4788-a75c-f36ad75e62a2.JPG").execute().body();
        System.out.println(body);
    }
}