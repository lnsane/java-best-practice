package com.best.spring.boot.kingdee.model.req;

import lombok.Data;

import java.util.List;

/**
 * @author CunLu Wang
 * @since 2022/10/12
 */
@Data
public class FEntity {
    // 物料编码
    private FNumber FMaterialId;
    /**
     * 库存单位
     */
    private FNumber FUnitID;

    /**
     * 数量
     */
    private int FQty;

    /**
     * 仓库编码
     */
    private FNumber FStockId;

    /**
     * 基本单位
     */
    private FNumber FBaseUnitID;

    /**
     * 货主类型
     */
    private String FOwnerTypeID;

    /**
     * 货主编码
     */
    private FNumber FOwnerID;

    /**
     * 保管者类型
     */
    private String FKeeperTypeID;


    /**
     * 保管者编码
     */
    private FNumber FKeeperID;

    /**
     * 入口时间
     */
    private String FInstockDate;

    /**
     * 子件类型
     */
    private List<FSubEntity> FSubEntity;


    /**
     * 销售单位
     */
    private FNumber FSaleUnitId;

    /**
     * 销售数量
     */
    private int FSaleQty;

    /**
     * SAL_SaleOrder
     */
    private String FSrcBillTypeId = "SAL_SaleOrder";

    /**
     * 销售订单单据编号
     */
    private String FSrcBillNo;

    /**
     * 关联
     */
    private List<FEntity_Link> FEntity_Link;
}
