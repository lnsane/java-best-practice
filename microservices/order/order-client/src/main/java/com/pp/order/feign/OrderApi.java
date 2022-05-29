package com.pp.order.feign;

import com.bao.common.core.bean.BaseResponse;
import com.pp.order.bean.OrderDTO;
import org.springframework.web.bind.annotation.GetMapping;

public interface OrderApi {
    @GetMapping("/order")
    BaseResponse<OrderDTO> getOrder();
}
