package com.best.spring.boot.kingdee.model.req;

import lombok.Data;

/**
 * @author CunLu Wang
 * @since 2022/10/12
 */
@Data
public class SubHeadEntity3 {
    /**
     * 库存单位 编码
     */
    private FNumber FStoreUnitID;

    /**
     * 币别编码
     */
    private FNumber FCurrencyId;
}
