package com.best.spring.boot.kingdee.model.req;

import lombok.Data;

/**
 * @author CunLu Wang
 * @since 2022/10/14
 */
@Data
public class FEntity_Link2 {
    /**
     * 推进路线
     */
    private Integer FEntity_Link_FFlowId = 0;

    /**
     * 单据转换规则
     */
    private String FEntity_Link_FRuleId = "SaleOrder-OutStock";

    /**
     * 源单表
     */
    private String FEntity_Link_FSTableName = "T_SAL_ORDERENTRY";

    /**
     * 主单据
     */
    private int FEntity_Link_FSBillId;


    /**
     * 子单据
     */
    private int FEntity_Link_FSId;


    /**
     * 原始携带量
     */
    private int FEntity_Link_FBaseUnitQtyOld;

    /**
     * 修改携带量
     */
    private int FEntity_Link_FBaseUnitQty;

    /**
     * 原始订单携带量（旧）
     */
    private int FEntity_Link_FSALBASEQTYOld;

    /**
     * 修改订单携带量
     */
    private int FEntity_Link_FSALBASEQTY;
}
