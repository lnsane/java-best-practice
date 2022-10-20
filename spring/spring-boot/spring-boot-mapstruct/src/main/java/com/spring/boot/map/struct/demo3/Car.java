package com.spring.boot.map.struct.demo3;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author CunLu Wang
 * @since 2022/9/22
 */
@Data
public class Car {
    private String name;

    private LocalDateTime localDateTime;

    private LocalDate localDate;

    private BigDecimal money;
}
