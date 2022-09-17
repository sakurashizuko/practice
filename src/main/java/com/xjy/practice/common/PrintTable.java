package com.xjy.practice.common;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lombok.Data;

@Data
public class PrintTable {

  private Table table;
  //最大列宽：sql查询结果某列内容可能过大，不想完全显示，因此限制最大列宽
  private Integer maxWidth;
  //最大条数:sql查询结果可能有非常多，通常不必完全显示，因此限制最大条数
  private Integer maxLength;

  public PrintTable(List<List<String>> content, Integer maxWidth, Integer maxLength) {
    this.table = buildTable(content);
    this.maxLength = maxLength;
    this.maxWidth = maxWidth;
  }

  public static String getPadString(String str, Integer len, String symbol, int index) {
    String origin = str + "  ";
    if (index == 0) {
      String tmp = getPadString(origin, len - 2);
      return symbol + tmp + symbol;
    } else {

      String tmp = getPadString(origin, len - 1);
      return tmp + symbol;
    }
  }

  /**
   * 将字符串填充到指定长度并居中对齐
   *
   * @param str
   * @param len
   * @return
   */
  public static String getPadString(String str, Integer len) {
    StringBuilder res = new StringBuilder();
    str = str.trim();
    if (str.length() < len) {
      int diff = len - str.length();
      int fixLen = diff / 2;
      String fix = getRepeatChar(" ", fixLen);
      res.append(fix).append(str).append(fix);
      if (res.length() > len) {
        return res.substring(0, len);
      } else {
        res.append(getRepeatChar(" ", len - res.length()));
        return res.toString();
      }
    }
    return str.substring(0, len);
  }

  public static void main(String[] args) {
    LocalDateTime now = LocalDateTime.now();
    Month month = now.getMonth();
    List<List<String>> content = new ArrayList<>();
    ArrayList<String> dates = new ArrayList<>();
    dates.add("日期");
    dates.add("体重");
    dates.add("学习一小时");
    dates.add("运动30min");
    dates.add("摄入不超过1400卡");
    content.add(dates);
    for (int j = 1; j <= month.maxLength(); j++) {
      ArrayList<String> day = new ArrayList<>();
      day.add(month.getValue() + "月" + j + "日");
      day.add("   ");
      day.add("   ");
      day.add("   ");
      day.add("   ");
      content.add(day);
    }

    PrintTable printTable = new PrintTable(content, month.maxLength() + 1, month.maxLength() + 1);
    printTable.printTable();
  }

  /**
   * 将str重复count次，返回结果
   *
   * @param str
   * @param count
   * @return
   */
  public static String getRepeatChar(String str, int count) {
    StringBuilder res = new StringBuilder();
    IntStream.range(0, count).forEach(i -> res.append(str));
    return res.toString();
  }

  /**
   * 得到一个字符串中单字节出现的次数
   *
   * @param cell
   * @return
   */
  public static Integer getEnCharCount(String cell) {
    if (cell == null) {
      return 0;
    }
    String reg = "[^\t\\x00-\\xff]";
    cell = cell.replaceAll(reg, "");
    //把·当做中文字符两个宽度
    return cell.replaceAll("·", "").length();
  }

  /**
   * 得到一个字符串中双字节出现的次数
   *
   * @param cell
   * @return
   */
  public static Integer getChCharCount(String cell) {
    if (cell == null) {
      return 0;
    }
    return cell.length() - getEnCharCount(cell);
  }

  /**
   * 创建Table实例
   *
   * @param content
   * @return
   */

  private Table buildTable(List<List<String>> content) {
    return new Table(content);
  }

  /**
   * 打印表格
   */
  public void printTable(String... symbols) {
    String symbol = symbols.length == 0 ? "|" : symbols[0];
    //按照最大列宽、最大数据量过滤后的表格
    Table limitTable = getLimitTable();
    //设置表格的最大宽度：得到每列宽度，再求和
    List<Integer> originMaxWidthList = getMaxWidthLenList(limitTable);
    limitTable.setMaxWidthList(originMaxWidthList);

    //得到格式化后的表格数据
    Table formatTable = getFormatTable(limitTable, symbol);
    Integer totalColSize = formatTable.getTotalColSize();
    //打印首行分割符号
    System.out.println(getRepeatChar("-", totalColSize));
    formatTable.getContent()
        .forEach(row -> {
          row.forEach(System.out::print);
          System.out.println();
          //打印每行分割符号
          System.out.println(getRepeatChar("-", totalColSize));
        });
  }

  /**
   * 格式化表格
   *
   * @param symbol 定义每列间隔符号
   * @return
   */
  private Table getFormatTable(Table table, String symbol) {
    //获取原表每列最大宽度
    List<Integer> originMaxWidthList = table.getMaxWidthList();
    //除了间隔符号外，固定在每个单元格前后加两个空格
    int symbolLen = symbol.length() + 2;
    //遍历原table，将每个单元格填充到该列最大长度
    List<List<String>> formatList = table.getContent().stream().map(
        row -> {
          //用于流在遍历每行的过程中，获取列序号
          AtomicInteger atomicInteger = new AtomicInteger(0);
          return row.stream().map(cell -> {
            //当前遍历的列序号
            int j = atomicInteger.getAndIncrement();
            //原表该列的最大宽度+间隔符号宽度-双字节出现的次数
            int cellSize = originMaxWidthList.get(j) + symbolLen - getChCharCount(cell);
            //如果是首行，还需要再前面加一个分割符号|，故长度加1
            cellSize = j == 0 ? cellSize + 1 : cellSize;
            //返回原始字符串按照指定symbol填充到指定长度cellSize，并居中对齐的字符
            return getPadString(cell, cellSize, symbol, j);
          }).collect(Collectors.toList());
        }
    ).collect(Collectors.toList());
    //存储格式化后的表格数据
    Table formatTable = buildTable(formatList);
    //设置格式化表格的总宽度：原始宽度+自定义分割符号的总宽度（列数*符号宽度）+首列前面的符号宽度
    int totalColSize = table.getTotalColSize() + table.getColCount() * symbolLen + 1;
    formatTable.setTotalColSize(totalColSize);
    return formatTable;
  }

  /**
   * @return 获取经过条件过滤的表格
   */
  private Table getLimitTable() {
    List<List<String>> limitContent = table.getContent().stream()
        .limit(maxLength)
        .map(row -> row.stream()
            //去除内容中含制表符时对结果展示的影响
            .map(cell -> cell == null ? null : cell.replaceAll("\t", " "))
            .map(cell -> cell != null && cell.length() > maxWidth ? cell.substring(0, maxWidth)
                : cell)
            .collect(Collectors.toList())
        ).collect(Collectors.toList());
    return buildTable(limitContent);
  }

  /**
   * 将字符串填充到指定长度并居中对齐
   *
   * @param str
   * @param len
   * @return
   */

  /**
   * 计算table每行的最大宽度 要使列宽相等，就需要将每个单元格宽度设置为该列最大宽度，二计算每行最大宽度相对容易些 故将content转置后得到的每行最大宽度即为所求
   * 需要考虑单双字节的情况，比如有数组arr:{"aabb","sql表格","编程学习"}, 按照String.length计算，arr[1]最长，但是实际上arr[2]看起来才是最宽的
   * 因此计算宽度时，将双字节字符看做2个单位长度，即：每出现一个双字节字符，长度+1
   *
   * @return
   */
  private List<Integer> getMaxWidthLenList(Table table) {
    //得到转置数组每个元素的长度,一个中文算两个长度
    return Arrays.stream(table.transpose())
        .map(rows -> Arrays.stream(rows)
            .mapToInt(s -> {
              //sql查询结果如果为null，则认为长度为4
              if (s == null) {
                return 4;
              } else {
                //加上双字节字符出现的次数，最短为null，四个字符
                return s.length() + getChCharCount(s);
              }
            }).max().orElse(0)
        ).collect(Collectors.toList());
  }

  @Data
  private static class Table {

    /**
     * 表格内容（含表头）
     */
    private List<List<String>> content = new ArrayList<>();

    /**
     * 表格列总字符长度：便于打印行分割符号
     */
    private Integer totalColSize;
    /**
     * 每列最大宽度
     */
    private List<Integer> maxWidthList;


    //private限制只能通过外部类构造
    private Table(List<List<String>> content) {
      this.content = content;
    }

    Integer getTotalColSize() {
      if (totalColSize == null && maxWidthList != null && !maxWidthList.isEmpty()) {
        this.totalColSize = maxWidthList.stream().reduce(Integer::sum).get();
      }
      return totalColSize;
    }

    //获取表格行数
    int getRowCount() {
      return content.size();
    }

    //获取表格列数，0行代表表头，默认认为content中至少含有表头
    int getColCount() {
      return content.get(0).size();
    }

    /**
     * 转置二维数组
     *
     * @return
     */
    private String[][] transpose() {
      int rowCount = getRowCount();
      int colCount = getColCount();
      String[][] result = new String[colCount][rowCount];

      for (int i = 0; i < rowCount; i++) {
        for (int j = 0; j < colCount; j++) {
          result[j][i] = content.get(i).get(j);
        }
      }
      return result;
    }

  }
}

