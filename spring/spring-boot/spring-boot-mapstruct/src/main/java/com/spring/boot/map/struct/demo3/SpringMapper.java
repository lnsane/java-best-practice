package com.spring.boot.map.struct.demo3;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Spring Mapper
 * @author admin
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface SpringMapper {

}
