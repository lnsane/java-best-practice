package com.spring.boot.map.struct.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Date;

/**
 * @author CunLu Wang
 * @since 2022/7/14
 */
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class BaseModel {
    private Date createTime;
    private Date updateTime;
}
