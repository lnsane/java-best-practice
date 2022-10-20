package com.best.spring.boot.kingdee.model.req;

import java.util.List;
import lombok.Data;

@Data
public class ReceiptRequest{
	private int fID;
	private String fCONTACTUNITTYPE;
	private List<FRECEIVEBILLENTRYItem> fRECEIVEBILLENTRY;
	private FNumber fSETTLECUR;
	private String fDATE;
	private FNumber fCURRENCYID;
	private FNumber fPAYORGID;
	private FNumber fSALEORGID;
	private FNumber fCONTACTUNIT;
	private FNumber fPAYUNIT;
	private FNumber2 fBillTypeID;
	private FNumber fSETTLEORGID;
	private String fPAYUNITTYPE;
}