package com.xjy.practice.design.设计模式.创建者模式.工厂模式.抽象工厂模式.factory;

import com.xjy.practice.design.设计模式.创建者模式.工厂模式.Coffee;
import com.xjy.practice.design.设计模式.创建者模式.工厂模式.抽象工厂模式.product.Dessert;


public interface DessertFactory {

  /**
   * 抽象工厂（Abstract Factory）：提供了创建产品的接口，调用者通过它访问具体工厂的工厂方法来创建产品。 具体工厂（ConcreteFactory）：主要是实现抽象工厂中的抽象方法，完成具体产品的创建。
   * @return 工厂创建的甜品
   */

  Coffee createCoffee();

  /**
   * 抽象工厂（Abstract Factory）：提供了创建产品的接口，调用者通过它访问具体工厂的工厂方法来创建产品。 具体工厂（ConcreteFactory）：主要是实现抽象工厂中的抽象方法，完成具体产品的创建。
   *
   * @return 工厂创建的甜品
   */
  Dessert createDessert();

}
