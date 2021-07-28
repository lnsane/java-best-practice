package com.best.spring.boot.elastic.search;
import cn.hutool.core.util.IdUtil;
import com.best.spring.boot.elastic.search.enums.SexEnum;

import com.best.spring.boot.elastic.search.model.User;
import com.best.spring.boot.elastic.search.repo.UserRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SpringBootElasticSearchDemoTest {
    @Autowired
    private UserRepo userRepo;
    @Test
    public void test(){
        String username = IdUtil.fastSimpleUUID();
        User user = new User();
        user.setUserName(username);
        user.setSex(SexEnum.MAN);
        userRepo.save(user);
        userRepo.findAll().forEach(user1 -> System.out.println(user1.toString()));
    }
}