package com.ds.spring.boot.ds.data.source.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ShardingJDBC{
    String value() default ShardingConfig.SHARDING;
}
