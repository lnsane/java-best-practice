package com.best.spring.boot.mybatis.plus.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.best.spring.boot.mybatis.plus.enums.SexEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 用户表
 */
@ApiModel(value = "用户表")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "test.`user3`")
//@KeySequence(value = "IdGen")
public class User {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.INPUT)
//    @TableField(value = "id",fill = FieldFill.INSERT)
    @ApiModelProperty(value = "主键")
    private Integer id;

    /**
     * 姓名
     */
    @TableField(value = "username")
    @ApiModelProperty(value = "姓名")
    private String username;

    /**
     * 性别 0 -> 未知 1-> 男 2-> 女
     */
    @TableField(value = "sex")
    @ApiModelProperty(value = "性别 0 -> 未知 1-> 男 2-> 女")
    private SexEnum sex;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;
}