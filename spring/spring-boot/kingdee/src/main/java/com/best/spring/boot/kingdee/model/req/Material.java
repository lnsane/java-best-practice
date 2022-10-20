package com.best.spring.boot.kingdee.model.req;

import lombok.Data;

/**
 * 新增物料
 *
 * @author CunLu Wang
 * @since 2022/10/12
 */
@Data
public class Material {
    /**
     * 物料ID
     */
    private String FMATERIALID;

    /**
     * 创建组织
     */
    private FNumber FCreateOrgId;

    /**
     * 使用组织
     */
    private FNumber FUseOrgId;

    /**
     * 分组编码
     */
    private FNumber FMaterialGroup;

    /**
     * 物料编码
     */
    private String FNumber;

    /**
     * 物料名
     */
    private String FName;


    /**
     * 规格型号
     */
    private String FSpecification;

    /**
     * 基本信息
     */
    private SubHeadEntity2 SubHeadEntity;

    /**
     * 库存信息
     */
    private SubHeadEntity3 SubHeadEntity1;
}
