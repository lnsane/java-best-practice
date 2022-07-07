package com.pspps.best.spring.boot.sharding.jdbc;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/test")
public class TestController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;








    @GetMapping
    @ResponseBody
    public void save() {
        System.out.println(1);
        for (int i = 0; i < 10; i++) {
            userService.save(User.builder().city(String.valueOf(i)).name(String.valueOf(i)).build());
        }
    }


    @GetMapping("delete")
    @ResponseBody
    public void delete() {
        userService.remove(Wrappers.<User>lambdaQuery().eq(User::getCity,"1"));
    }

    @GetMapping("page")
    @ResponseBody
    public List<UserVO> page(@RequestParam("p") Long p,@RequestParam("z") Long z){
        Page<User> page = new Page<>(p,z);
        IPage<UserVO> iPage = userMapper.pagesss(page);
        System.out.println(iPage.getTotal());
        return iPage.getRecords();
    }



}
