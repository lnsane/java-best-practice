package com.best.spring.boot.kingdee.model.req;

import lombok.Data;

@Data
public class FSaleOrderFinance{
	private FNumber fSettleCurrId;
	private FNumber fExchangeTypeId;
	private boolean fIsIncludedTax;
	private boolean fIsPriceExcludeTax;
}