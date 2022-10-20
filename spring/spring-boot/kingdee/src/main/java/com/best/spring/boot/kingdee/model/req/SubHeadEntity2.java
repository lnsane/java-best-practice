package com.best.spring.boot.kingdee.model.req;

import lombok.Data;

/**
 * 基本信息
 * @author CunLu Wang
 * @since 2022/10/12
 */
@Data
public class SubHeadEntity2 {
    /**
     * 物料属性
     */
    public String FErpClsID;

    /**
     * 存货类别
     */
    private FNumber FCategoryID;


    /**
     * 默认税率
     */
    private FNumber FTaxRateId;


    /**
     * 基本单位
     */
    private FNumber FBaseUnitId;


    /**
     * 重量单位
     */
    private FNumber  FWEIGHTUNITID;

}
