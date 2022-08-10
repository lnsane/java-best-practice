package com.spring.boot.map.struct.controller;

import com.spring.boot.map.struct.copy.FaceCopy;
import com.spring.boot.map.struct.copy.UserParams;
import com.spring.boot.map.struct.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author CunLu Wang
 * @since 2022/7/14
 */
@RestController
public class UserController {
    @Autowired
    private FaceCopy faceCopy;
    @PostMapping
    public void hell(User user) {
        System.out.println(faceCopy.supdateUser(new User()));
        System.out.println(user);
        UserParams userParams = new UserParams();
    }
}
