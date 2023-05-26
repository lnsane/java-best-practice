package com.best.spring.cloud.openfeign.lnheritance;

import com.best.spring.cloud.openfeign.bean.Data;
import com.best.spring.cloud.openfeign.bean.User;
import com.best.spring.cloud.openfeign.bean.Username;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lnsane
 */
@RestController
public class HelloController implements Hello {
    @Autowired
    private Hello2Feign hello2Feign;
    @Autowired
    private HttpServletRequest request;

    @Override
    public Data<List<User<Username>>> hello() {
        Data<List<User<Username>>> userData = new Data<>();
        List<User<Username>> user = new ArrayList<>();
        Username username = new Username();
        username.setAge("123");
        User<Username> usernameUser = new User<>();
        usernameUser.setUsername(username);
        user.add(usernameUser);
        userData.setS(user);
        return userData;
    }

    @GetMapping("/123")
    public void one(HttpServletRequest httpServletRequest) {
        System.out.println(request);
        System.out.println(httpServletRequest);
        System.out.println("123");
    }

}
