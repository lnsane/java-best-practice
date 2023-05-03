package com.best.spring.cloud.knife4j.user;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author CunLu Wang
 * @since 2023/5/3
 */
@RestController
@Api(tags = "用户")
public class UserController {
    @ApiOperation(value = "用户信息")
    @GetMapping(value = "/getInfo")
    public void getInfo() {

    }
}
