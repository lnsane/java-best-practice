package com.spring.boot.map.struct.demo3;

import cn.hutool.core.date.DatePattern;
import com.spring.boot.map.struct.MoneyUtils;
import lombok.Data;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;
import java.util.Set;

/**
 * @author CunLu Wang
 * @since 2022/9/22
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {MoneyUtils.class})
public interface CarCopy {

    /**
     *
     * @param car
     * @return
     */
    @BeanMapping(ignoreByDefault = true)
//    @Mapping(target = "money",source = "money")
    @Mapping(target = "money",source = "money",qualifiedByName = "convent")
    @Mapping(target = "name",source = "name")
    @Mapping(target = "createTime",dateFormat = DatePattern.NORM_TIME_PATTERN,source = "localDateTime")
    @Mapping(target = "createDateTime",dateFormat = DatePattern.NORM_DATE_PATTERN,source = "localDate")
    CarDto copy(Car car);
}
