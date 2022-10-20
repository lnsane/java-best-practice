package com.best.spring.boot.kingdee.model.req;

import lombok.Data;

/**
 * @author CunLu Wang
 * @since 2022/10/12
 */
@Data
public class FSubEntity {
    /**
     * 物料编码
     */
    private FNumber FMaterialIDSETY;

    /**
     * 单位
     */
    private FNumber FUnitIDSETY;

    /**
     * 数量
     */
    private int FQtySETY;

    /**
     * 基本单位
     */
    private FNumber FBaseUnitIDSETY;

    /**
     * 保管者类型
     */
    private String FKeeperTypeIDSETY;

    /**
     * 保管着
     */
    private FNumber FKeeperIDSETY;

    /**
     * 货主类型
     */
    private String FOwnerTypeIDSETY;

    /**
     * 货主
     */
    private FNumber FOwnerIDSETY;


    /**
     * 仓库编码
     */
    private FNumber FStockIDSETY;
}
