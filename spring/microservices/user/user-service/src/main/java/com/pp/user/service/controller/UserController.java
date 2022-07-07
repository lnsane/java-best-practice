package com.pp.user.service.controller;

import com.bao.common.core.bean.BaseResponse;
import com.pp.user.service.OrderDTO;
import com.pp.user.service.OrderFeign;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Qualifier("com.pp.user.service.OrderFeign")
    @Autowired
    private OrderFeign orderFeign;
    @GetMapping("get")
    @ApiOperation("12312")
    public void get(){
        BaseResponse<OrderDTO> order = orderFeign.getOrder();
        System.out.println(order.getStatus());
    }
}
