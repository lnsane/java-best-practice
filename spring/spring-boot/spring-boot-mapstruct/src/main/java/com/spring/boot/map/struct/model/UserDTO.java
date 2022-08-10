package com.spring.boot.map.struct.model;

import com.spring.boot.map.struct.model.emuns.SexEnums;
import lombok.Data;

/**
 * @author CunLu Wang
 * @since 2022/7/14
 */
@Data
public class UserDTO extends BaseModel{
    private String userName;
    private Integer userAge;
    private Integer income;
    private SexEnums sexEnums;
}
