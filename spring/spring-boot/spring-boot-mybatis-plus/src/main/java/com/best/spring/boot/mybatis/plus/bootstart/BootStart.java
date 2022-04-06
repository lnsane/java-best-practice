package com.best.spring.boot.mybatis.plus.bootstart;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.best.spring.boot.mybatis.plus.entity.User;
import com.best.spring.boot.mybatis.plus.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//@Component
@Slf4j
public class BootStart implements CommandLineRunner {
    @Autowired
    private UserService userService;

    @Override
    public void run(String... args) throws Exception {
        int t = 0;
        while (true) {
            User user = new User();
            LambdaQueryWrapper<User> userLambdaQueryWrapper = Wrappers.lambdaQuery();
            try {
                while (true) {
                    t++;
                    userLambdaQueryWrapper.eq(User::getUsername, "111");
                    if (t > 4000) {
                        break;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                User one = userService.getOne(userLambdaQueryWrapper);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
