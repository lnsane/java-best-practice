package com.spring.boot.map.struct.plus;

import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;

/**
 * @author CunLu Wang
 * @since 2023/7/24
 */
@AutoMapper(target = UserDto.class)
@Data
public class User {

    private String userName;
}
