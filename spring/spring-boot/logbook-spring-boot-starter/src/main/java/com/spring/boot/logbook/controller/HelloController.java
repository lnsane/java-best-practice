package com.spring.boot.logbook.controller;

import com.spring.boot.logbook.AService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;

/**
 * @author CunLu Wang
 * @since 2023/7/5
 */
@RestController
@Configuration
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
