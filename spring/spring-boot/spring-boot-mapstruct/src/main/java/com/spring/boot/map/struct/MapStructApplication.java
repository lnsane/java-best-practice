package com.spring.boot.map.struct;

import com.spring.boot.map.struct.copy.UserCopy;
import com.spring.boot.map.struct.model.User;
import com.spring.boot.map.struct.model.UserDTO;
import com.spring.boot.map.struct.model.emuns.SexEnums;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.Date;

/**
 * @author CunLu Wang
 * @since 2022/7/14
 */
@SpringBootApplication
public class MapStructApplication {
    public static void main(String[] args) {
        SpringApplication.run(MapStructApplication.class,args);
    }

    @Autowired
    private UserCopy userCopy;

    @PostConstruct
    public void helllo(){
        User user = User.builder().build();
        user.setUserName("1");
        user.setAge(1);
        user.setIncome(123);
        user.setSexEnums(SexEnums.MAN);
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        UserDTO copy = userCopy.copy(user,1111);


        System.out.println(copy);
    }
}
