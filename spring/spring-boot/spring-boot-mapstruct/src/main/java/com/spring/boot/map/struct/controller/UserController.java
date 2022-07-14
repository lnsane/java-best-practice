package com.spring.boot.map.struct.controller;

import com.spring.boot.map.struct.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author CunLu Wang
 * @since 2022/7/14
 */
@RestController
public class UserController {
    @PostMapping
    public void hell(User user) {
        System.out.println(user);
    }
}
