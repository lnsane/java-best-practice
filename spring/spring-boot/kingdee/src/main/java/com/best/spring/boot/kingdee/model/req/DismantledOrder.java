package com.best.spring.boot.kingdee.model.req;

import lombok.Data;

import java.util.List;

/**
 * @author CunLu Wang
 * @since 2022/10/12
 */
@Data
public class DismantledOrder {
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
    // 库存组织
    private FNumber FStockOrgId;
    private String FAffairType = "Assembly";

    // 货主类型
    private String FOwnerTypeIdHead;
    //货主编码
    private FNumber FOwnerIdHead;

    // 子件货主类型
    private String FSubProOwnTypeIdH;
    // 子件货主编码
    private FNumber FSubProOwnerIdH;

    private List<FEntity> FEntity;
}
