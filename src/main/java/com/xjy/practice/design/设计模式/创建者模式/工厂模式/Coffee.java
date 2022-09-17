package com.xjy.practice.design.设计模式.创建者模式.工厂模式;

import lombok.Data;

@Data
public abstract class Coffee {

  /**
   * 打印咖啡名称
   *
   * @return 咖啡名称
   */
  public abstract void printName();

  public void addSugar() {

    System.out.println("CoffeeaddSugar ");
  }

  public void addMilk() {
    System.out.println("Coffee addMilk");
  }
}
