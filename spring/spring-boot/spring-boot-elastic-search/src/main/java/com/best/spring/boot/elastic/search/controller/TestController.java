package com.best.spring.boot.elastic.search.controller;

import cn.hutool.core.util.IdUtil;
import com.best.spring.boot.elastic.search.enums.SexEnum;
import com.best.spring.boot.elastic.search.model.User;
import com.best.spring.boot.elastic.search.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class TestController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping("save")
    public void save(){
        String username = IdUtil.fastSimpleUUID();
        User user = new User();
        user.setUserName(username);
        user.setSex(SexEnum.MAN);
        userRepo.save(user);
    }

    @GetMapping("test")
    public Page<User> test(){
        Page<User> all1 = userRepo.findAll(Pageable.ofSize(10));
        return all1;
    }

    @GetMapping("gets")
    public User gets(@RequestParam("userName") String userName){
        return userRepo.findFirstByUserNameAndSex(userName, SexEnum.MAN);
    }

    @PostMapping("update")
    public void update(@RequestBody UserParams userParams){
        Optional<User> byId = userRepo.findById(userParams.getId());
        byId.ifPresent(user -> {
            user.setUserName(userParams.getUserName());
            userRepo.save(user);
        });
    }


}
