package com.xjy.practice.design.设计模式.创建者模式.工厂模式;

import lombok.Data;

/**
 * 美式咖啡
 * @author xjy
 */
@Data
public class CafeAmericano extends Coffee {

  /**
   * 获取名称
   *
   * @return cafe name
   */
  @Override
  public void printName() {
    System.out.println("CafeAmericano");
    ;
  }

}
