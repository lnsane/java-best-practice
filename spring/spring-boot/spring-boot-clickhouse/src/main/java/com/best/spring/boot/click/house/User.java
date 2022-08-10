package com.best.spring.boot.click.house;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户表
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
//    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;


    /**
     * 主键
     */
    @TableField(value = "number")
//    @JsonSerialize(using = ToStringSerializer.class)
    private Long number;

    /**
     * 姓名
     */
    @TableField(value = "username")
    private String username;

    /**
     * 姓名
     */
    @TableField(value = "age")
    private Integer age;

    /**
     * 姓名
     */
    @TableField(value = "area")
    private String area;

    /**
     * 姓名
     */
    @TableField(value = "money")
    private Integer money;


    /**
     * 姓名
     */
    @TableField(value = "create_time")
    private String createTime;



}