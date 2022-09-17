package com.xjy.practice.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString

public enum RiskCallBackStatusEnum {
  PASS("A7", "信审中");

  private String code;
  private String desc;


}
