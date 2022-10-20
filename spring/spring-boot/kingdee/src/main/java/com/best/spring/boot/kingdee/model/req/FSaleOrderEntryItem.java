package com.best.spring.boot.kingdee.model.req;

import lombok.Data;

import java.util.List;

@Data
public class FSaleOrderEntryItem{
	private boolean fIsFree;
	private FNumber FMaterialId;
	private int fQty;
	private String fOwnerTypeId;
	private int fTaxPrice;
	private int fEntryTaxRate;
	private FNumber FPriceUnitId;
	private FNumber fOwnerId;
	private String fDeliveryDate;
	private FNumber FUnitID;
	private String fRowType;
	private FNumber FStockUnitID;

	/**
	 * 电讯销售员
	 */
	private FNumber3 F_PFAH_Base;

	/**
	 * 电讯销售部门
	 */
	private FNumber F_PFAH_Base1;
	/**
	 * 仓库
	 */
	private FNumber FSOStockId;


}