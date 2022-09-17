package com.xjy.practice.design.设计模式.创建者模式.工厂模式.抽象工厂模式;

import com.xjy.practice.design.设计模式.创建者模式.工厂模式.Coffee;
import com.xjy.practice.design.设计模式.创建者模式.工厂模式.抽象工厂模式.factory.impl.AmericanDessertFactory;
import com.xjy.practice.design.设计模式.创建者模式.工厂模式.抽象工厂模式.factory.impl.ChineseDessertFactory;
import com.xjy.practice.design.设计模式.创建者模式.工厂模式.抽象工厂模式.product.Dessert;

/**
 * #### 4.2.4.4 使用场景
 *
 * * 当需要创建的对象是一系列相互关联或相互依赖的产品族时，如电器工厂中的电视机、洗衣机、空调等。
 *
 * * 系统中有多个产品族，但每次只使用其中的某一族产品。如有人只喜欢穿某一个品牌的衣服和鞋。
 *
 * * 系统中提供了产品的类库，且所有产品的接口相同，客户端不依赖产品实例的创建细节和内部结构。
 *
 * 如：输入法换皮肤，一整套一起换。生成不同操作系统的程序。
 */
public class Customer {

  public static void main(String[] args) {
    ChineseDessertFactory chineseDessertFactory = new ChineseDessertFactory();
    AmericanDessertFactory dessertFactory = new AmericanDessertFactory();
    Coffee coffee = dessertFactory.createCoffee();
    Dessert dessert = dessertFactory.createDessert();
    coffee.printName();
    dessert.printCalorie();
  }
}
