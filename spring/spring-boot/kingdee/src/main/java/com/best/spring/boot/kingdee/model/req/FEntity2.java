package com.best.spring.boot.kingdee.model.req;

import lombok.Data;

import java.util.List;

/**
 * @author CunLu Wang
 * @since 2022/10/12
 */
@Data
public class FEntity2 {
    // 物料编码
    private FNumber FMaterialId;
    /**
     * 库存单位
     */
    private FNumber FUnitID;

    /**
     * 数量
     */
    private int FRealQty;


    /**
     * 是否免费
     */
    private boolean FIsFree;

    /**
     * 货主编码
     */
    private FNumber FOwnerID;


    /**
     * 仓库编码
     */
    private FNumber FStockID;

    /**
     * 货主类型
     */
    private String FOwnerTypeID;


    /**
     * 电讯销售员
     */
    private FNumber3 F_PFAH_Base;

    /**
     * 电讯销售部门
     */
    private FNumber F_PFAH_Base1;


    /**
     * 源单类型
     */
    private String FSrcType = "SAL_SaleOrder";

    /**
     * 销售订单单号
     */
    private String FSrcBillNo;

    /**
     * 销售订单单号
     */
    private String FSoorDerno;

    /**
     * 子销售订单id
     */
    private int FSOEntryId;

    /**
     * 关联信息
     */
    private List<FEntity_Link2> FEntity_Link;
}
