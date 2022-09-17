package com.xjy.practice.model;

import com.alibaba.excel.annotation.ExcelProperty;
import java.util.Date;
import lombok.Data;

@Data
public class ReadItem {

  @ExcelProperty(value = "日期", index = 0)
  private Date date;
  @ExcelProperty(value = "content", index = 1)

  private String content;
}
