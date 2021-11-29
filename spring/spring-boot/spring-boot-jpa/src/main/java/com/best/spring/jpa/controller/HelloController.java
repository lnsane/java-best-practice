package com.best.spring.jpa.controller;

import com.best.spring.jpa.dao.Resouce;
import com.best.spring.jpa.dao.User;
import com.best.spring.jpa.dao.UserInfo;
import com.best.spring.jpa.repo.ResouceRepo;
import com.best.spring.jpa.repo.UserInfoRepo;
import com.best.spring.jpa.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 王存露
 */
@RestController
public class HelloController {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private UserInfoRepo userInfoRepo;
    @Autowired
    private ResouceRepo resouceRepo;

    @GetMapping("/")
    public List<User> getAllUser() {
        List<User> all = userRepo.findAll();
        List<UserInfo> all1 = userInfoRepo.findAll();
        userInfoRepo.deleteAll();
        List<Resouce> all2 = resouceRepo.findAll();
        return all;
    }

}
