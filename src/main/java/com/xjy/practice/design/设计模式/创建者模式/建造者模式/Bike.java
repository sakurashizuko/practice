package com.xjy.practice.design.设计模式.创建者模式.建造者模式;

import lombok.Data;

/**
 * 具体产品类
 *
 * @author mac
 */
@Data
public class Bike {

  /**
   * 车架
   */
  private String frame;
  /**
   * 品牌
   */
  private String brand;

  private String seat;


}
