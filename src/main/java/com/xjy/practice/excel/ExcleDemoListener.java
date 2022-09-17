package com.xjy.practice.excel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.write.builder.ExcelWriterBuilder;
import com.xjy.practice.model.ExportItem;
import com.xjy.practice.model.ReadItem;
import java.math.BigDecimal;
import java.util.ArrayList;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExcleDemoListener extends AnalysisEventListener<ReadItem> {


  private final ArrayList<ExportItem> exportItems = new ArrayList();

  @Override
  public void invoke(ReadItem readItem, AnalysisContext analysisContext) {
//蒜叶4.6*4=18、黑茄子7.5*4=30、大肠6.2*9=43
    log.info("解析到一条数据:{}", readItem);
    String content = readItem.getContent().trim();
    String[] split = content.split("、");
    for (String s : split) {

      String[] split1 = s.split("=");
      //蒜叶4.6*4
      String prefix = split1[0];
//            蒜叶4.6、4
      String[] split2 = prefix.split("\\*");
      //            4
      Double count = Double.parseDouble(split2[1]);
      //蒜叶4.6
      String nameAndPrice = split2[0];
      int subindex = -1;
      for (int i = nameAndPrice.toCharArray().length - 1; i >= 0; i--) {
        char ch = nameAndPrice.charAt(i);
        // 判断输入的数字是否为数字还是字符
        if (!Character.isDigit(ch) && '.' != (ch)) {
          subindex = i;
          break;
        }
      }
      String name = nameAndPrice.substring(0, subindex + 1);
      double price = Double.parseDouble(nameAndPrice.substring(subindex + 1));
      BigDecimal total = BigDecimal.valueOf(price * count);
      total = total.setScale(2, BigDecimal.ROUND_HALF_UP);

      ExportItem exportItem = ExportItem.builder()
          .date(readItem.getDate())
          .itemName(name)
          .price(price)
          .total(total.doubleValue())
          .count(count).build();
      log.info("解析到一条数据:{}", exportItem.toString());
      exportItems.add(exportItem);
    }


  }


  @Override
  public void doAfterAllAnalysed(AnalysisContext analysisContext) {
    log.info("所有数据解析完成！");
    exportItems.forEach(System.out::println);
    ExcelWriterBuilder workBook = EasyExcel.write("/Users/mac/Downloads/a1.xlsx", ExportItem.class);
//        // sheet方法参数： 工作表的顺序号（从0开始）或者工作表的名字
    workBook.sheet().doWrite(exportItems);

  }
}