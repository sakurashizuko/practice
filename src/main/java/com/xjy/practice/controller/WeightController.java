package com.xjy.practice.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.xjy.practice.common.PrintTable;
import com.xjy.practice.common.constant.LoseTargetEnum;
import com.xjy.practice.model.RUserWeight;
import com.xjy.practice.service.UserService;
import com.xjy.practice.service.UserWeightService;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin
@RestController
@RequestMapping("/weight")
public class WeightController {

  private static final DateTimeFormatter DATE_FORMAT;
  private static final String FILE_NAME = "weight.txt";

  static {
    DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy/MM/dd");
  }

  @Autowired
  private UserWeightService weightService;
  @Autowired
  private UserService userService;

  private static void refreshFile(LinkedHashMap<String, Double> dateTimeDoubleHashMap) {
    try {
      FileWriter var4 = new FileWriter(FILE_NAME);
      dateTimeDoubleHashMap.forEach((k, v) -> {
        try {
          var4.write(k + "," + v + "\n");
        } catch (IOException e) {
          e.printStackTrace();
        }
      });

      var4.close();
    } catch (IOException var5) {
      System.out.println("文件写入失败！" + var5);
    }
  }

  private static LinkedHashMap<String, Double> readRecord() {
    BufferedReader br = null;
    LinkedHashMap<String, Double> timeDoubleHashMap = new LinkedHashMap<>();

    try {
      FileReader fileReader = new FileReader(FILE_NAME);
      br = new BufferedReader(fileReader);
      String contentLine;
      while ((contentLine = br.readLine()) != null) {
        //读取每一行，并输出
        //将每一行追加到arr1
        String[] strings = contentLine.split(",");
        String date = strings[0].trim();
        String weight = strings[1].trim();
        timeDoubleHashMap.put(date, Double.valueOf(weight));

      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return timeDoubleHashMap;
  }

  public static void everyDay(LinkedHashMap<String, Double> hashMap) {

  }

  public static void printTable(LinkedHashMap<String, Double> hashMap) {
    Month month = LocalDateTime.now().getMonth();
    List<List<String>> content = new ArrayList<>();
    ArrayList<String> dates = new ArrayList<>();
    dates.add("日期");
    dates.add("  体重  ");
    dates.add("学习一小时");
    dates.add("运动30min");
    dates.add("摄入不超过1400卡");
    content.add(dates);
    for (int j = 1; j <= month.maxLength(); j++) {
      ArrayList<String> day = new ArrayList<>();
      String monthValue =
          "/" + (LocalDateTime.now().getMonthValue() < 10 ? "0" + LocalDateTime.now()
              .getMonthValue() : LocalDateTime.now().getMonthValue() + "");
      String dateValue = "/" + (j < 10 ? "0" + j : j + "");

      String key = LocalDateTime.now().getYear() + monthValue + dateValue;
      String weight = hashMap.get(key) == null ? "" : hashMap.get(key) + "";

      day.add(key);
      day.add(weight);
      day.add("   ");
      day.add("   ");
      day.add("   ");
      content.add(day);
    }

    PrintTable printTable = new PrintTable(content, month.maxLength() + 1, month.maxLength() + 1);
    printTable.printTable();
  }/**/

  @GetMapping("/saveTodayWeight/{weight}/{eat}/{burn}/{hasStuday}")
  public String saveTodayWeight(@PathVariable("weight") Double weight,
      @PathVariable("eat") Integer eat, @PathVariable("burn") Integer burn,
      @PathVariable("hasStuday") Integer hasStuday) {

    if (weight > 50 && weight < 70) {
      weight = (weight * 2);
    }
    String todayDate = DATE_FORMAT.format(LocalDateTime.now());
    RUserWeight userWeight = weightService.getBaseMapper()
        .selectOne(new LambdaQueryWrapper<RUserWeight>()
            .eq(RUserWeight::getUserId, 1)
            .eq(RUserWeight::getRecordTime, todayDate));
    if (userWeight == null) {
      RUserWeight weightDto = new RUserWeight();
      weightDto.setWeight(weight);
      weightDto.setUserId(1L);
      weightDto.setBurnKcal(burn);
      weightDto.setEatKcal(eat);
      weightDto.setHasStudy(hasStuday > 0 ? 1 : 0);
      weightDto.setRecordTime(todayDate);
      weightService.getBaseMapper().insert(weightDto);
      userWeight = weightDto;

    } else {
      userWeight.setWeight(weight);
      userWeight.setBurnKcal(burn);
      userWeight.setEatKcal(eat);
      userWeight.setHasStudy(hasStuday > 0 ? 1 : 0);
      weightService.getBaseMapper().updateById(userWeight);
    }
    LinkedHashMap<String, Double> hashMap = readRecord();
    hashMap.put(todayDate, weight);
    refreshFile(hashMap);
    // printTable(hashMap);
    String momentWord = getMomentWord(hashMap);
    BigDecimal weightBigDecimal = BigDecimal.valueOf(weight);
    BigDecimal targetWeight = BigDecimal.valueOf(108);
    BigDecimal remain = weightBigDecimal.subtract(targetWeight);
    String studyWord = String.format(
        "Date: [%s]\n还需减去[%s]斤\n今日摄入卡路里:[%s]Kcal\n运动消耗卡路里:[%s]Kcal\n学习了没呀:[%s]",
        todayDate, remain, userWeight.getEatKcal(), userWeight.getBurnKcal(),
        userWeight.getHasStudy() > 0 ? "YES!" : "NO");
    sendDingTalk(studyWord);

    //        sendDingTalk(momentWord);
    return momentWord;
  }

  @GetMapping("/test")
  public void test() {
    weightService.testA();
  }

  @GetMapping("/getRecords")
  public List<RUserWeight> getRecords() {
    LinkedHashMap<String, Double> map = readRecord();
    return map.keySet().stream().map(k -> {
          RUserWeight weight = new RUserWeight();
          weight.setRecordTime(k);
          weight.setWeight(map.get(k));
          return weight;
        }
    ).collect(Collectors.toList());

  }

  public String getMomentWord(LinkedHashMap<String, Double> map) {
    LocalDateTime today = LocalDateTime.now();
    int month = today.getMonth().getValue();
    String todayDate = DATE_FORMAT.format(today);
    BigDecimal weight = BigDecimal.valueOf(map.get(todayDate));
    BigDecimal targetWeight = BigDecimal.valueOf(108);
    BigDecimal remain = weight.subtract(targetWeight);

    StringBuilder sb = new StringBuilder();
    sb.append("Date: [").append(todayDate).append("] \n");
    LocalDateTime startDate = LocalDateTime.of(2022, 8, 1, 0, 0);
    Duration duration = Duration.between(startDate, today);
    sb.append("Day: [").append(duration.getSeconds() / 60 / 60 / 24 + 1).append("]\n");
    sb.append("仍需减重 [").append(remain).append("]斤\n");
    BigDecimal monthTargetWeight = LoseTargetEnum.getMonthTargetWeight(month);
    BigDecimal monthRemain = weight.subtract(monthTargetWeight);
    String str = weight.compareTo(monthTargetWeight) > 0 ?
        month + "月还要减肥 [" + (monthRemain) + "]斤!!\n革命尚未成功，同志仍需努力~~~~~"
        : "[" + month + "]月目标已完成！棒棒哒！！";

    BigDecimal ondDay = weight.subtract(
        BigDecimal.valueOf(map.get(DATE_FORMAT.format(today.minusDays(1)))));
    String format2 = "体重较昨天%s[%s]斤! %s\n";
    if (ondDay.doubleValue() < 0.00) {
      format2 = String.format(format2, "减轻了", ondDay.abs().doubleValue(), "(*^▽^*)");
    } else if (ondDay.doubleValue() > 0.00) {
      format2 = String.format(format2, "增重了", ondDay.doubleValue(), "o(╥﹏╥)o");

    } else {
      format2 = "体重较昨天持平，无变化!\n";
    }
    sb.append(format2);
    sb.append(str);
    sb.append("\n\t");

    return sb.toString();
  }

  private void sendDingTalk(String momentWord) {

    String url = "https://oapi.dingtalk.com/robot/send?access_token=9cc0cf46fb9bf0e4617577a2152caa2b3d4e7e41c9148633fe79099c3a480ffa";
    HttpClient httpclient = new DefaultHttpClient();
    HttpPost httppost = new HttpPost(url);
    httppost.addHeader("Content-type", "application/json; charset=utf-8");
    httppost.setHeader("Accept", "application/json");
    String json = String.format("{\"msgtype\": \"text\",\"text\": {\"content\":\"%s\"}}",
        momentWord);
    StringEntity entity = new StringEntity(json, StandardCharsets.UTF_8);
    httppost.setEntity(entity);

    try {
      HttpResponse resp = httpclient.execute(httppost);
      System.out.println(resp.toString());
    } catch (IOException e) {
      e.printStackTrace();
    }


  }
}
