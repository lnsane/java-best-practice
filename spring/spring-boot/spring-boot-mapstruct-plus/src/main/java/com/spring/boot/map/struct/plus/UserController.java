package com.spring.boot.map.struct.plus;

import io.github.linpeilie.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author CunLu Wang
 * @since 2023/7/24
 */
@RestController
public class UserController {
    @Autowired
    private Converter converter;
    @GetMapping("/user")
    public void user() {
            User user = new User();
            UserDto convert = converter.convert(user, UserDto.class);
            System.out.println(convert);
    }
}
