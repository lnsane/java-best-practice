package com.best.spring.boot.kingdee.config;

import com.kingdee.bos.webapi.sdk.K3CloudApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author CunLu Wang
 * @since 2022/9/14
 */
@Configuration
public class KingdeeConfigure {
    @Autowired
    private KingdeeProperties kingdeeProperties;

    @Bean
    public K3CloudApi createK3CloudApi(){
        return new K3CloudApi(kingdeeProperties);
    }
}
