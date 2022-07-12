package com.ds.spring.boot.ds.data.source.config;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

@Getter
@Setter
@ConfigurationProperties(prefix = ShardingConfig.PREFIX)
public class ShardingConfig {
    public static final String PREFIX = "spring.datasource.sharding-jdbc";
    public final static String SHARDING = "sharding-jdbc";

    public Map<String,JdbcConfig> datasource;

    public Boolean showSql = Boolean.FALSE;

    @Data
    public static class JdbcConfig {
        private String url;
        private String username;
        private String password;
        private String driverClassName;
    }
}
