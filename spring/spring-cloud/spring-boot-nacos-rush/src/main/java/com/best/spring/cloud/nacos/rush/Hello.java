package com.best.spring.cloud.nacos.rush;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author CunLu Wang
 * @since 2023/5/22
 */
@Configuration
@ConfigurationProperties(prefix = "hellos")
public class Hello {
    public String getWorld() {
        return world;
    }

    public void setWorld(String world) {
        this.world = world;
    }

    private String world;
}
