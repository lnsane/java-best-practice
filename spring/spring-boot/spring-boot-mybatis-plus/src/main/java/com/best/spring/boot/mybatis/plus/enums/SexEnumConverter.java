package com.best.spring.boot.mybatis.plus.enums;

import lombok.NonNull;
import org.springframework.core.convert.converter.Converter;

public class SexEnumConverter implements Converter<String, SexEnum> {
    @Override
    public SexEnum convert(@NonNull String source) {
        return SexEnum.of(Integer.valueOf(source));
    }
}
