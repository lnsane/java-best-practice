package com.spring.boot.map.struct.model;

import com.spring.boot.map.struct.model.emuns.SexEnums;
import lombok.Data;
import lombok.experimental.SuperBuilder;

/**
 * @author CunLu Wang
 * @since 2022/7/14
 */
@Data
@SuperBuilder
public class UserDTO extends BaseModel{
    private String userName;
    private Integer userAge;
    private Integer income;
    private SexEnums sexEnums;
}
