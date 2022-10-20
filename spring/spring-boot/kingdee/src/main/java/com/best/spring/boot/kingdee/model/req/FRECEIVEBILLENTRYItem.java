package com.best.spring.boot.kingdee.model.req;

import lombok.Data;

@Data
public class FRECEIVEBILLENTRYItem{
	private double fRECAMOUNTFORE;
	private FNumber fACCOUNTID;
	private double fNOTVERIFICATEAMOUNT;
	private String fPOSTDATE;
	private double fRECTOTALAMOUNTFOR;
	private FNumber fPURPOSEID;
	private FNumber fSETTLETYPEID;
}