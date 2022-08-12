package com.spring.boot.yapi.model.vo;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 订单响应类
 */
@Data
@Builder
public class OrderVO {

    /**
     * 订单id
     * @mock @string('lower',1,8)
     */
    @NotBlank
    private String orderId;


    /**
     * 订单的状态
     * @mock @string('lower',1,8)
     */
    @NotBlank
    private String orderStatus;


    /**
     * 订单的金额
     * @mock @natural(0,1000)
     */
    @NotNull
    private Integer orderSum;
}
