package com.pp.seata.order;

import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/test22")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("isExist")
    @ResponseBody
    public void isExist() {
        userService.hello();
    }
}
