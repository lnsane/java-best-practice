package com.spring.boot.map.struct.model;

import com.spring.boot.map.struct.model.emuns.SexEnums;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @author CunLu Wang
 * @since 2022/7/14
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseModel{
    private String userName;
    private Integer age;
    private Integer income;
    private SexEnums sexEnums;


}
