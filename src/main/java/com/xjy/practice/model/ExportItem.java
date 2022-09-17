package com.xjy.practice.model;

import com.alibaba.excel.annotation.ExcelProperty;
import java.util.Date;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public
class ExportItem {

  @ExcelProperty(value = "日期", index = 0)
  private Date date;
  @ExcelProperty(value = "商品名称", index = 1)
  private String itemName;
  @ExcelProperty(value = "单价", index = 2)
  private Double price;
  @ExcelProperty(value = "数量", index = 3)
  private Double count;
  @ExcelProperty(value = "总价", index = 4)
  private Double total;
}