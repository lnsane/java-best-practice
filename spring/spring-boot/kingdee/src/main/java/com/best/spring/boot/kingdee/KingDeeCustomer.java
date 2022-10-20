package com.best.spring.boot.kingdee;

import com.kingdee.bos.webapi.entity.BatchSave;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Setter
@Getter
public class KingDeeCustomer<T> extends BatchSave<T> {
	private String isAutoSubmitAndAudit;


	public KingDeeCustomer(List<T> data) {
		super(data);
	}
}