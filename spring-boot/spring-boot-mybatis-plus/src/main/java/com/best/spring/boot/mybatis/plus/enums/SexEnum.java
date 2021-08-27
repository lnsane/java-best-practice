package com.best.spring.boot.mybatis.plus.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum SexEnum {
    UNKNOWN(0),
    MAN(1),
    WOMAN(2);

    @EnumValue
    Integer code;

    SexEnum(Integer code) {
        this.code = code;
    }

    @JsonCreator
    public static SexEnum of(Integer value) {
        if (null == value) {
            return null;
        }

        for (SexEnum item : SexEnum.values()) {
            if (value.equals(item.getCode())) {
                return item;
            }
        }
        return null;
    }

    @JsonValue
    public Integer getCode() {
        return code;
    }
}
