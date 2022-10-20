package com.best.spring.boot.kingdee;

import com.kingdee.bos.webapi.entity.BatchSave;
import com.kingdee.bos.webapi.entity.SaveParam;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Setter
@Getter
public class KingDeeOne<T> extends SaveParam<T> {
	private String isAutoSubmitAndAudit;

	public KingDeeOne(T data) {
		super(data);
	}
}