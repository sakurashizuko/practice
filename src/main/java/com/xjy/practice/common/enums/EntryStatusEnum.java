package com.xjy.practice.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public enum EntryStatusEnum {

  PASS("A10", "信审通过");

  private String code;
  private String desc;
}
