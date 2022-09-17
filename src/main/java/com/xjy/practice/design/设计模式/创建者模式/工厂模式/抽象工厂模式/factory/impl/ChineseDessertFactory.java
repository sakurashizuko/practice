package com.xjy.practice.design.设计模式.创建者模式.工厂模式.抽象工厂模式.factory.impl;

import com.xjy.practice.design.设计模式.创建者模式.工厂模式.Coffee;
import com.xjy.practice.design.设计模式.创建者模式.工厂模式.CoffeeLatte;
import com.xjy.practice.design.设计模式.创建者模式.工厂模式.抽象工厂模式.product.Dessert;
import com.xjy.practice.design.设计模式.创建者模式.工厂模式.抽象工厂模式.factory.DessertFactory;
import com.xjy.practice.design.设计模式.创建者模式.工厂模式.抽象工厂模式.product.impl.PeachCake;

/**
 * 中式甜品工厂  生产拿铁和桃子蛋糕
 */
public class ChineseDessertFactory implements DessertFactory {

  @Override
  public Coffee createCoffee() {
    return new CoffeeLatte();
  }

  @Override
  public Dessert createDessert() {
    return new PeachCake();
  }
}
