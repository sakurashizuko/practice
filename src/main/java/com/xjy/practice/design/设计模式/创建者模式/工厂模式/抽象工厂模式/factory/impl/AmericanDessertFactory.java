package com.xjy.practice.design.设计模式.创建者模式.工厂模式.抽象工厂模式.factory.impl;

import com.xjy.practice.design.设计模式.创建者模式.工厂模式.CafeAmericano;
import com.xjy.practice.design.设计模式.创建者模式.工厂模式.Coffee;
import com.xjy.practice.design.设计模式.创建者模式.工厂模式.抽象工厂模式.product.Dessert;
import com.xjy.practice.design.设计模式.创建者模式.工厂模式.抽象工厂模式.factory.DessertFactory;
import com.xjy.practice.design.设计模式.创建者模式.工厂模式.抽象工厂模式.product.impl.ApplePie;

/**
 * 美式甜品工厂  生产美式和苹果pie
 */
public class AmericanDessertFactory implements DessertFactory {

  @Override
  public Coffee createCoffee() {
    return new CafeAmericano();
  }

  @Override
  public Dessert createDessert() {
    return  new ApplePie();
  }
}
