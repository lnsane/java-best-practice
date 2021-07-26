package com.best.spring.jpa.repo;

import cn.hutool.core.util.IdUtil;
import com.best.spring.jpa.dao.Role;
import com.best.spring.jpa.dao.User;
import com.best.spring.jpa.dao.UserInfo;
import com.best.spring.jpa.enums.SexEnums;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepoTest {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private RoleRepo roleRepo;
    @Autowired
    private UserInfoRepo userInfoRepo;

    @Test
    public void test() {
        String fastUUID = IdUtil.fastUUID();
        User user = new User();
        user.setUserName(fastUUID);

        userRepo.save(user);

        User firstByUserName = userRepo.findFirstByUserName(fastUUID);

        Assert.assertNotEquals(firstByUserName, null);

    }


    @Test
    public void testRole() {
        String fastUUID = IdUtil.fastUUID();
        Role role = new Role();
        role.setRole(fastUUID);

        roleRepo.save(role);

        Role firstByUserName = roleRepo.findFirstByRole(fastUUID);

        Assert.assertNotEquals(firstByUserName, null);
    }


    @Test
    public void testUserJoinRole() {
        String userName = IdUtil.fastUUID();

        User user = new User();
        user.setUserName(userName);

        String role1 = IdUtil.fastUUID();

        String role2 = IdUtil.fastUUID();

        Role role = new Role();
        role.setRole(role1);

        Role roletwo = new Role();
        roletwo.setRole(role2);

        user.getRoles()
            .add(role);
        user.getRoles()
            .add(roletwo);

        roletwo.setUser(user);

        role.setUser(user);
        userRepo.save(user);
        roleRepo.save(role);
    }

    @Test
    public void testUserInfo() {
        String userName = IdUtil.fastUUID();

        User user = new User();
        user.setUserName(userName);

        String role1 = IdUtil.fastUUID();

        String role2 = IdUtil.fastUUID();

        UserInfo userInfo = new UserInfo();

        userInfo.setUser(user);
        userInfo.setSex(SexEnums.MAN);

        Role role = new Role();
        role.setRole(role1);

        Role roletwo = new Role();
        roletwo.setRole(role2);

        user.getRoles()
            .add(role);
        user.getRoles()
            .add(roletwo);

        roletwo.setUser(user);

        role.setUser(user);

        userInfoRepo.save(userInfo);

        userRepo.save(user);
        roleRepo.save(role);


    }

    @Test
    public void queryJoinUserAndRole() {
        List<User> all = userRepo.findAll();
        System.out.println(all);
    }
}