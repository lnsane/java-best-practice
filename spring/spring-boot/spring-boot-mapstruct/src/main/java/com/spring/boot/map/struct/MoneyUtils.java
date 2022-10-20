package com.spring.boot.map.struct;

import org.mapstruct.Named;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @author CunLu Wang
 * @since 2022/9/22
 */
@Component
public class MoneyUtils {

    @Named("convent")
    public String convent(BigDecimal money) {
        return money.toString();
    }
}
