package com.best.spring.boot.kingdee.model.req;

import lombok.Data;

import java.util.List;

/**
 *
 * @author CunLu Wang
 * @since 2022/10/12
 */
@Data
public class SalesReceiptRequest {
    /**
     * 主键
     */
    private int fID;
    /**
     * 编码
     */
    private String FBillNo;

    /**
     * 单据类型
     */
    private FNumber fBillTypeID;

    // 日期
    private String fDATE;

    /**
     * 销售组织
     */
    private FNumber fSaleOrgId;

    /**
     * 客户编码
     */
    private FNumber FCustomerID;

    /**
     * 发送组织
     */
    private FNumber FStockOrgId;

    /**
     * 货主类型
     */
    private String FOwnerTypeIdHead;

    /**
     * 子体
     */
    private SubHeadEntity SubHeadEntity;


    /**
     * 明细数据
     */
    private List<FEntity2> FEntity;
}
