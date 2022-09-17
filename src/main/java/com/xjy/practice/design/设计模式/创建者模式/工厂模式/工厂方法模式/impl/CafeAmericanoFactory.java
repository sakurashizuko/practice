package com.xjy.practice.design.设计模式.创建者模式.工厂模式.工厂方法模式.impl;

import com.xjy.practice.design.设计模式.创建者模式.工厂模式.CafeAmericano;
import com.xjy.practice.design.设计模式.创建者模式.工厂模式.Coffee;
import com.xjy.practice.design.设计模式.创建者模式.工厂模式.工厂方法模式.CoffeeFactory;

public class CafeAmericanoFactory implements CoffeeFactory {

  @Override
  public Coffee createCoffee() {
    return new CafeAmericano();
  }
}
