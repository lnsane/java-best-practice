package com.spring.boot.map.struct.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * @author CunLu Wang
 * @since 2022/7/14
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BaseModel {
    private Date createTime;
    private Date updateTime;
    private Integer age;
}
