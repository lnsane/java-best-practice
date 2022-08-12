package com.spring.boot.yapi.model.params;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * 保存订单信息
 */
@Data
@Builder
public class OrderParams {

    /**
     * 订单名
     * @default abc
     * @mock tangcent
     */
    @NotBlank
    private String orderName;


    /**
     * 保存的sku数组
     * @mock ["asd"]
     */
    private List<String> skus;
}
