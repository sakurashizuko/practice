package com.xjy.practice.design.设计模式.创建者模式.工厂模式.抽象工厂模式.product;

import com.xjy.practice.design.设计模式.创建者模式.工厂模式.Coffee;
import com.xjy.practice.design.设计模式.创建者模式.工厂模式.CoffeeTypeEnum;

/**
 是一种为访问类提供一个创建一组相关或相互依赖对象的接口，且访问类无须指定所要产品的具体类就能得到同族的不同等级的产品的模式结构。
 抽象工厂模式是工厂方法模式的升级版本，工厂方法模式只生产一个等级的产品，而抽象工厂模式可生产多个等级的产品。


 * @author mac
 */
public abstract  class Dessert {

  public abstract void printCalorie();

}
