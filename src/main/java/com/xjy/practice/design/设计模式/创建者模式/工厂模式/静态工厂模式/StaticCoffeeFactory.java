package com.xjy.practice.design.设计模式.创建者模式.工厂模式.静态工厂模式;

import com.xjy.practice.design.设计模式.创建者模式.工厂模式.Coffee;
import com.xjy.practice.design.设计模式.创建者模式.工厂模式.CoffeeTypeEnum;

/**
 * 不属于23中  是一种设计思想 1. 抽象产品 具体产品
 * <p>
 * 具体工厂 抽象产品 ：定义了产品的规范，描述了产品的主要特性和功能。 具体产品 ：实现或者继承抽象产品的子类 具体工厂 ：提供了创建产品的方法，调用者通过该方法来获取产品。
 * @author mac
 */
public class StaticCoffeeFactory {

  public static  Coffee createCoffee(CoffeeTypeEnum type) {
    try {
      Class<? extends Coffee> typeClass = type.getTypeClass();
      Coffee instance = typeClass.newInstance();
      return instance;
    } catch (InstantiationException | IllegalAccessException e) {
      e.printStackTrace();
    }
    return null;
  }

}
