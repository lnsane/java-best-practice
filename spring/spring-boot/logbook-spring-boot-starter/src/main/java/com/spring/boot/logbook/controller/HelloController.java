package com.spring.boot.logbook.controller;

import com.spring.boot.logbook.AService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpRequest;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletRequest;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author CunLu Wang
 * @since 2023/7/5
 */
@RestController
@Configuration
@EnableAsync
public class HelloController {
    @Autowired
    private AService aService;
    @GetMapping("/api/hello/{i}")
    public HashMap<String,String> hello(@PathVariable int i) {
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("1213","44444");
        aService.hello();
        return hashMap;
    }

    @GetMapping("/api/hellos")
    public HashMap<String,String> hello(ServletRequest request) {
        Future<Integer> hello = aService.hello();

        try {
            while(!hello.isDone()) {
                break;
            }
            Integer integer = hello.get(10, TimeUnit.SECONDS);
            System.out.println(integer);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (TimeoutException e) {
            throw new RuntimeException(e);
        }
        System.out.println(hello);
        System.out.println(1);
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("1213","44444");

        return hashMap;
    }

    @PostMapping("/api/hello2")
    public HashMap<String,String> hello2(@RequestBody HelloBody helloBody) {
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("1213","44444");
        aService.hello();
        return hashMap;
    }

    @PostMapping("/api/hello4")
    public HashMap<String,String> hello4(@RequestPart("file") MultipartFile multipartFile) {
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("1213","44444");
        aService.hello();
        return hashMap;
    }


}
