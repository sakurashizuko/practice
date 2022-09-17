package com.xjy.practice.design.设计模式.创建者模式.工厂模式;

import com.xjy.practice.design.设计模式.创建者模式.工厂模式.工厂方法模式.CoffeeFactory;
import com.xjy.practice.design.设计模式.创建者模式.工厂模式.简单工厂模式.SimpleCoffeeFactory;
import com.xjy.practice.design.设计模式.创建者模式.工厂模式.静态工厂模式.StaticCoffeeFactory;

public class Cafe {

  private CoffeeFactory coffeeFactory;

  public Coffee order(CoffeeTypeEnum type) {
//这种写法 将创建咖啡的过程在下单中包含，可以进一步提取出创建咖啡的方法  下单 再返回咖啡 无需暴露如何制作的咖啡
    try {
      Class<? extends Coffee> typeClass = type.getTypeClass();
      Coffee instance = typeClass.newInstance();
      instance.addMilk();
      instance.addSugar();
      return instance;
    } catch (InstantiationException | IllegalAccessException e) {
      e.printStackTrace();
    }

    return null;
  }

  //使用简单工厂模式 将cafe 与 制作具体Coffee的过程解耦 产生了新的耦合 cafe和工厂的耦合 如果
  public Coffee order2(CoffeeTypeEnum type) {
    SimpleCoffeeFactory coffeeFactory = new SimpleCoffeeFactory();
    Coffee coffee = coffeeFactory.createCoffee(type);
    coffee.addMilk();
    coffee.addSugar();
    return coffee;

  }

  //使用静态工厂模式 无需创建工厂对象
  public Coffee order3(CoffeeTypeEnum type) {

    Coffee coffee = StaticCoffeeFactory.createCoffee(type);
    coffee.addMilk();
    coffee.addSugar();
   
     coffee.printName();

    return coffee;

  }

  public void setCoffeeFactory(CoffeeFactory coffeeFactory) {
    this.coffeeFactory = coffeeFactory;
  }

  //使用工厂方法模式
  public Coffee order4() {
    Coffee coffee = coffeeFactory.createCoffee();
    coffee.addMilk();
    coffee.addSugar();
     coffee.printName();
    return coffee;

  }


  public Coffee order5(CoffeeTypeEnum type) {
    return null;
  }
}

