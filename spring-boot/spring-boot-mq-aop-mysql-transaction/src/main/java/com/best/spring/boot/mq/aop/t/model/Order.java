package com.best.spring.boot.mq.aop.t.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "`order`")
public class Order {
    public static final String COL_ID = "id";
    public static final String COL_ORDER_NAME = "order_name";
    public static final String COL_STATE = "state";
    public static final String COL_CREATE_TIME = "create_time";
    public static final String COL_UPDATE_TIME = "update_time";
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;
    @TableField(value = "order_name")
    private String orderName;
    /**
     * 1 -> 未上架  2 - > 调用上传亚马逊创建文档完毕
     * 3 -> 上传完毕 4 -> 调用下载亚马逊报告摘要完毕
     * 5 -> 上架成功 6 - > 异常
     */
    @TableField(value = "`state`")
    private Integer state;
    @TableField(value = "create_time")
    private Date createTime;
    @TableField(value = "update_time")
    private Date updateTime;
}