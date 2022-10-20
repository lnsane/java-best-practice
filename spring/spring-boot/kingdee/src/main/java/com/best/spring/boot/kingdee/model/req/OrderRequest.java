package com.best.spring.boot.kingdee.model.req;

import java.util.List;

import com.kingdee.bos.webapi.entity.SaveParam;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequest {
	private int fID;
	/**
	 * 销售组织
	 */
	private FNumber fSaleOrgId;
	private FNumber fSaleDeptId;
	private FSaleOrderFinance FSaleOrderFinance;
	private FNumber fCustId;
	/**
	 * 单据类型.编码	XSDD01_SYS  标准销售订单（默认）
	 * XSDD02_SYS  寄售销售订单
	 * XSDD03_SYS  受托加工销售
	 * XSDD04_SYS  直运销售订单
	 * XSDD05_SYS  退货订单
	 * XSDD06_SYS  分销调拨订单
	 * XSDD07_SYS  分销购销订单
	 * XSDD08_SYS  VMI销售订单
	 * XSDD09_SYS  现销订单
	 */
	private FNumber2 fBillTypeID;
	private String fDate;
	private List<FSaleOrderEntryItem> FSaleOrderEntry;
	private FNumber fSalerId;
	/**
	 * 关联收款单
	 */
	private List<FSaleOrderPlan> FSaleOrderPlan;



}