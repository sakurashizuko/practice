package com.xjy.practice.设计模式.创建者模式.单例模式;

// 1. 单例类  实用类
public class Singleton {

  private static Singleton singleton = new Singleton();
  private String name;

  //    饿汉式 静态成员变量 1. 私有构造方法 2， 在本类中创建本类对象  3. 提供公共访问方法
  private Singleton() {
  }

  public static Singleton getInstance() {

    return singleton;
  }
}
