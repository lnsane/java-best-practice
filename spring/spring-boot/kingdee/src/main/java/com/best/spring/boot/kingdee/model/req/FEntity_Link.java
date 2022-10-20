package com.best.spring.boot.kingdee.model.req;

import lombok.Data;

/**
 * @author CunLu Wang
 * @since 2022/10/13
 */
@Data
public class FEntity_Link {
    private int FEntity_Link_FFlowId = 0;

    private String FEntity_Link_FRuleId = "SAL_Order-STK_Assembly";

    private int FEntity_Link_FSTableId = 0;

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
     * 数量
     */
    private int FEntity_Link_FBaseQtyOld;

    /**
     * 数量
     */
    private int  FEntity_Link_FBaseQty;
}
