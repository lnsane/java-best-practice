package com.spring.boot.map.struct.demo3;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author CunLu Wang
 * @since 2022/9/22
 */
@Data
public class CarDto {
    private String name;

    private String createTime;

    private String createDateTime;

    private String money;
}
