package com.spring.boot.map.struct.model;

import com.spring.boot.map.struct.model.emuns.SexEnums;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author CunLu Wang
 * @since 2022/7/14
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User{
    private String userName;
    private Integer age;
    private Integer income;
    private SexEnums sexEnums;


}
