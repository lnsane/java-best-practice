package com.best.spring.boot.mybatis.page.helper;

import com.best.spring.boot.mybatis.page.helper.mapper.User;
import com.best.spring.boot.mybatis.page.helper.mapper.UserMapper;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.PostConstruct;
import java.util.List;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.best.spring.boot.mybatis.page.helper.mapper"})
@MapperScan(basePackages = {"com.best.spring.boot.mybatis.page.helper.mapper"})
public class SpringBootMybatisPageHelper {


    @Autowired
    private UserMapper userMapper;
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
        SpringApplication.run(SpringBootMybatisPageHelper.class, args);
    }

    /**
     * 关键执行代码  count = ExecutorUtil.executeAutoCount(this.dialect, executor, countMs, parameter, boundSql, rowBounds, resultHandler);
     *
     */
    @PostConstruct
    public void sdasd(){
        Page<User> page = PageHelper.startPage(1, 10);
        Page<User> list = userMapper.selectList();
        PageInfo<User> userPageInfo = list.toPageInfo();
        System.out.println(userPageInfo.getList().size());
//        PageInfo pages = new PageInfo(list);
//        System.out.println(pages);
    }
//    public static void main(String[] args) {
//        List<String> ts;
//        ts = null;
//        List<String> collect = Optional.ofNullable(ts).orElse(Collections.emptyList()).stream().collect(Collectors.toList());
//        System.out.println(collect);
//    }


}
