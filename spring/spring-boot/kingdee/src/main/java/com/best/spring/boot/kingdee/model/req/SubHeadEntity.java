package com.best.spring.boot.kingdee.model.req;

import lombok.Data;

/**
 * @author CunLu Wang
 * @since 2022/10/12
 */
@Data
public class SubHeadEntity {
    private FNumber fSettleCurrId;
    private FNumber fExchangeTypeId;
    private FNumber FSettleOrgID;
    private boolean fIsIncludedTax;
    private boolean fIsPriceExcludeTax;
}
