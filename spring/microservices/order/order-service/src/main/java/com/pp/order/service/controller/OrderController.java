package com.pp.order.service.controller;

import com.bao.common.core.bean.BaseResponse;
import com.pp.order.bean.OrderDTO;
import com.pp.order.feign.OrderApi;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController implements OrderApi {





    @Override
    @ApiOperation("123123124124")
    public BaseResponse<OrderDTO> getOrder() {
        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrderId("10000");
        return BaseResponse.ok(orderDTO);
    }


}
