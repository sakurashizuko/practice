package com.xjy.practice.设计模式.创建者模式.单例模式;

// 1. 单例类  实用类
public class Singleton2 {

  // 声明单例的对象
  private static Singleton2 instance;

  static {
    instance = new Singleton2();
  }

  private String name;

  //    饿汉式 静态代码块 1. 私有构造方法 2， 在本类中创建本类对象  3. 提供公共访问方法
  private Singleton2() {
  }

  public static Singleton2 getInstance() {
    return instance;
  }
}
