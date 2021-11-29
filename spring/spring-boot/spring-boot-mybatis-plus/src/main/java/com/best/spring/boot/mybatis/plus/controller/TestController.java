package com.best.spring.boot.mybatis.plus.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.best.spring.boot.mybatis.plus.entity.User;
import com.best.spring.boot.mybatis.plus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

@Controller
@RequestMapping(value = "/test")
public class TestController extends BaseController {
    @Autowired
    private UserService userService;

    @PostMapping("/page")
    @ResponseBody
    public Page<User> getPage(@RequestBody(required = false) Page<User> page) {
        return userService.page(page);
    }

    @PostMapping
    @ResponseBody
    public void save(@RequestBody User user) {
        Optional.ofNullable(user).ifPresent(t -> {
            t.setCreateTime(new Date());
            t.setUpdateTime(new Date());
            userService.save(t);
        });
    }

    @PutMapping
    @ResponseBody
    public void update(@RequestBody User user) {
        Optional.ofNullable(user).ifPresent(t -> {
            if (Optional.ofNullable(user.getId()).isPresent()) {
                userService.update(user, Wrappers.<User>lambdaUpdate().eq(User::getId, user.getId()));
            }
        });
    }
}
