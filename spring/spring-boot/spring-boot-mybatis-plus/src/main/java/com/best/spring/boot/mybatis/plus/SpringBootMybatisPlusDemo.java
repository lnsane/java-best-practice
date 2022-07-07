package com.best.spring.boot.mybatis.plus;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan(value = "com.best.spring.boot.mybatis.plus.mapper")
public class SpringBootMybatisPlusDemo {


    /**
     * 解决Jackson导致Long型数据精度丢失问题
     * @return
     */
    @Bean
    public ObjectMapper jacksonObjectMapper(Jackson2ObjectMapperBuilder builder) {
        ObjectMapper objectMapper = builder.createXmlMapper(false).build();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        SimpleModule module = new SimpleModule();
        module.addSerializer(Long.class, ToStringSerializer.instance);
        module.addSerializer(Long.TYPE, ToStringSerializer.instance);
        objectMapper.registerModule(module);
        return objectMapper;
    }
    public static void main(String[] args) {
        SpringApplication.run(SpringBootMybatisPlusDemo.class, args);
    }

//    public static void main(String[] args) {
//        List<String> ts;
//        ts = null;
//        List<String> collect = Optional.ofNullable(ts).orElse(Collections.emptyList()).stream().collect(Collectors.toList());
//        System.out.println(collect);
//    }
}
