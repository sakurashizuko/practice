package com.xjy.practice.design.设计模式.创建者模式.单例模式;

import java.io.Serializable;

// 1. 懒汉式 静态内部类
public class Singleton4 implements Serializable {

  // 声明单例的对象Ò
  private static volatile Singleton4 instance;
  private String name;

  //    懒汉式  1. 私有构造方法
  private Singleton4() {
    System.out.println("init Singleton4");
  }

  //2， 声明一个静态内部类
  private static class SingletonHolder {

    private static final Singleton4 INSTANCE = new Singleton4();


  }

  // 3. 提供公共访问方法 将静态内部类的属性返回
  public static Singleton4 getInstance() {
    return SingletonHolder.INSTANCE;
  }

}
