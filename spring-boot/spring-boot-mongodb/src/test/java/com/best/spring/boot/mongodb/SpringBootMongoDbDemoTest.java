package com.best.spring.boot.mongodb;

import com.best.spring.boot.mongodb.enums.SexEnum;
import com.best.spring.boot.mongodb.model.User;
import com.best.spring.boot.mongodb.repo.UserRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootMongoDbDemoTest {

    @Autowired
    private UserRepo userRepo;

    @Test
    public void test() {
        User user = new User();
        user.setName("1111");
        user.setSex(SexEnum.MAN);
        userRepo.save(user);
    }

    @Test
    public void findAll() {
        userRepo.findAll()
                .forEach(user -> System.out.println(user.toString()));
    }

}