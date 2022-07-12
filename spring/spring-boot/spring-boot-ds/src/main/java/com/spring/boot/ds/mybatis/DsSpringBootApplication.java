package com.spring.boot.ds.mybatis;

import com.baomidou.dynamic.datasource.provider.DynamicDataSourceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;

@SpringBootApplication
public class DsSpringBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(DsSpringBootApplication.class,args);
    }
    @Autowired
    private List<DynamicDataSourceProvider> providers;
    @PostConstruct
    public void hello(){
        System.out.println(providers);
    }
}
