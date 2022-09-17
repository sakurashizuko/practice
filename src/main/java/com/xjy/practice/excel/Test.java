package com.xjy.practice.excel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.builder.ExcelReaderBuilder;
import com.alibaba.excel.read.builder.ExcelReaderSheetBuilder;
import com.xjy.practice.model.ReadItem;

public class Test {

  public static void main(String[] args) {
    // 这里默认读取第一个sheet
    ExcelReaderBuilder workBook = EasyExcel.read
        ("/Users/mac/Downloads/a.xlsx", ReadItem.class, new ExcleDemoListener());

    // 封装工作表
    ExcelReaderSheetBuilder sheet1 = workBook.sheet();
    // 读取
    sheet1.doRead();


  }
}



