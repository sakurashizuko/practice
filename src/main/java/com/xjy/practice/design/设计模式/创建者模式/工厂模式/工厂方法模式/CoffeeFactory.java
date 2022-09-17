package com.xjy.practice.design.设计模式.创建者模式.工厂模式.工厂方法模式;

import com.xjy.practice.design.设计模式.创建者模式.工厂模式.Coffee;

/**
 * 不属于23中  是一种设计思想 1. 抽象产品 具体产品
 * <p>
 * <p>
 * 定义一个用于创建对象的接口，让子类决定实例化哪个产品类对象。工厂方法使一个产品类的实例化延迟到其工厂的子类。
 * <p>
 * #### 4.2.3.2 结构
 * <p>
 * 工厂方法模式的主要角色：
 * <p>
 * 抽象工厂（Abstract Factory）：提供了创建产品的接口，调用者通过它访问具体工厂的工厂方法来创建产品。 具体工厂（ConcreteFactory）：主要是实现抽象工厂中的抽象方法，完成具体产品的创建。
 * 抽象产品（Product）：定义了产品的规范，描述了产品的主要特性和功能。 * 具体产品（ConcreteProduct）：实现了抽象产品角色所定义的接口，由具体工厂来创建，它同具体工厂之间一一对应。
 *
 * @author mac
 */
public interface CoffeeFactory {

    /** * 抽象工厂（Abstract Factory）：提供了创建产品的接口，调用者通过它访问具体工厂的工厂方法来创建产品。 具体工厂（ConcreteFactory）：主要是实现抽象工厂中的抽象方法，完成具体产品的创建。
     *
     */

 Coffee createCoffee();

}
