package com.xjy.practice.design.设计模式.创建者模式.工厂模式.抽象工厂模式.product.impl;

import com.xjy.practice.design.设计模式.创建者模式.工厂模式.抽象工厂模式.product.Dessert;

public class ApplePie extends Dessert  implements  Cloneable{

  @Override
  public Object clone() throws CloneNotSupportedException {
    return super.clone();
  }

  @Override
  public void printCalorie() {
    System.out.println("ApplePie 255Kcal/100g");
  }
}
