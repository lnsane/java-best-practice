package com.best.spring.boot.easy.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Demo implements Serializable {
    @ExcelProperty("订单编号")
    @ColumnWidth(10)
    private String id;
    @ExcelProperty("下单时间")
    @ColumnWidth(20)
    private Date upcSequence;

}
