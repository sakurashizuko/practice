package com.xjy.practice.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.xjy.practice.common.constant.LoseTargetEnum;
import com.xjy.practice.model.RUser;
import com.xjy.practice.model.RUserWeight;
import com.xjy.practice.service.UserService;
import com.xjy.practice.service.UserWeightService;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 爬虫作业配置表 前端控制器
 * </p>
 *
 * @author zf
 * @since 2022-06-02
 */
@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

  private static final SimpleDateFormat dateFormat;

  static {
    dateFormat = new SimpleDateFormat("yyyy/MM/dd");

  }

  @Autowired
  private UserService userService;

  @Autowired
  private UserWeightService weightService;

  /**
   * 测试接口：根据id拿记录
   *
   * @param id id
   * @return result
   */
  @GetMapping("/getUserById/{id}")
  public RUser getUserById(@PathVariable("id") Integer id) {
    return userService.getBaseMapper().selectById(id);
  }

  @GetMapping("/saveTodayWeight/{userId}/{weight}")
  public String saveTodayWeight(@PathVariable("userId") Integer userId,
      @PathVariable("weight") Double weight) {
    if (weight < 50) {
      return "真的瘦到" + weight + "公斤了吗？";

    }
    if (weight > 70 && weight < 100) {
      return "真的瘦到" + weight + "公斤了吗？";

    }
    if (weight > 50 && weight < 70) {
      weight = (weight * 2);
    }

    String todayDate = dateFormat.format(new Date());
    RUserWeight userWeight = weightService.getBaseMapper()
        .selectOne(new LambdaQueryWrapper<RUserWeight>()
            .eq(RUserWeight::getUserId, userId)
            .eq(RUserWeight::getRecordTime, todayDate));
    if (userWeight == null) {
      RUserWeight weightDto = new RUserWeight();
      weightDto.setWeight(weight);
      weightDto.setUserId(Long.valueOf(userId));
      weightDto.setRecordTime(todayDate);
      weightService.getBaseMapper().insert(weightDto);

    } else {
      userWeight.setWeight(weight);
      weightService.getBaseMapper().updateById(userWeight);
    }
    String momentWord = getMomentWord(userId);
    return momentWord;
  }


  @GetMapping("/getTodayWeight/{userId}")
  public Double getTodayWeight(@PathVariable("userId") Long userId) {
    String todayDate = dateFormat.format(new Date());
    RUserWeight userWeight = weightService.getBaseMapper().selectOne(
        new LambdaQueryWrapper<RUserWeight>().select(RUserWeight::getWeight)
            .eq(RUserWeight::getUserId, userId).eq(RUserWeight::getRecordTime, todayDate));
    return userWeight.getWeight();

  }

  @GetMapping("/getMomentWord/{userId}")
  public String getMomentWord(@PathVariable("userId") Integer userId) {
    String todayDate = dateFormat.format(new Date());

    RUser RUser = userService.getBaseMapper().selectById(userId);
    BigDecimal targetWeight = BigDecimal.valueOf(RUser.getTargetWeight());
    List<RUserWeight> RUserWeights = weightService.getBaseMapper().selectList(
        new LambdaQueryWrapper<RUserWeight>().eq(RUserWeight::getUserId, userId)
            .orderByDesc(RUserWeight::getCreateTime));
    RUserWeight last = RUserWeights.get(0);
    BigDecimal weight = BigDecimal.valueOf(last.getWeight());
    StringBuilder sb = new StringBuilder();
    sb.append("Date:").append(todayDate).append("\n");
    BigDecimal remain = weight.subtract(targetWeight);
    sb.append("当前体重 [").append(weight).append("]斤\n");
    sb.append("目标体重 [").append(targetWeight).append("]斤\n");
    sb.append("仍需减重 [").append(remain).append("]斤\n");
    int month = LocalDateTime.now().getMonth().getValue();
    BigDecimal monthTargetWeight = LoseTargetEnum.getMonthTargetWeight(month);
    BigDecimal monthRemain = weight.subtract(monthTargetWeight);
    // System.out.println(decimal.doubleValue());
    String str = weight.compareTo(monthTargetWeight) > 0 ?
        month + "月还要减肥 [" + (monthRemain) + "]斤!!\n革命尚未成功，同志仍需努力~~~~~"
        : "[" + month + "]月目标已完成！棒棒哒！！";
    BigDecimal yesterdayWeight = BigDecimal.valueOf(RUserWeights.get(1).getWeight());
    BigDecimal ondDay = weight.subtract(yesterdayWeight);
    String format2 = "体重较昨天%s[%s]斤! %s\n";
    if (ondDay.doubleValue() < 0.00) {
      format2 = String.format(format2, "减轻了", ondDay.doubleValue(), "(*^▽^*)");
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


  @GetMapping("/getRecordsByUserId/{id}")
  public List<RUserWeight> getAllWeight(@PathVariable("id") Integer userId) {
    return weightService.getBaseMapper()
        .selectList(new LambdaQueryWrapper<RUserWeight>()
            .eq(RUserWeight::getUserId, userId)
            .orderByAsc(RUserWeight::getCreateTime));
  }

}