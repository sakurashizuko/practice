package com.xjy.practice.common.constant;


import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum LoseTargetEnum {

  August(8, 118.0),
  September(9, 114.0),
  October(10, 110.0),
  November(11, 108.0),
  December(12, 108.0);
  private final Integer month;
  private final Double monthTargetWeight;

  public static BigDecimal getMonthTargetWeight(Integer month) {
    BigDecimal returnVal = BigDecimal.valueOf(108.0);
    for (LoseTargetEnum value : LoseTargetEnum.values()) {
      if (value.getMonth().equals(month)) {
        returnVal = BigDecimal.valueOf(value.getMonthTargetWeight());
      }
    }
    return returnVal;
  }
}
