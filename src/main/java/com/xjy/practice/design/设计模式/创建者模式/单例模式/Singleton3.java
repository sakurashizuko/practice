package com.xjy.practice.design.设计模式.创建者模式.单例模式;

// 1. 懒汉式 使用时才创建对象
public class Singleton3 {

  // 声明单例的对象Ò
  private static volatile Singleton3 instance;
  private String name;

  //    懒汉式  1. 私有构造方法 2， 在本类中创建本类对象
  private Singleton3() {
  }

  // 3. 提供公共访问方法
  public static Singleton3 getInstance() {
    // 判断是否为空 为空创建 否则返回
    if (null == instance) {
      instance = new Singleton3();
    }
    return instance;
  }

  // 3. 提供公共访问方法 多线程huan
  public static synchronized Singleton3 getInstanceSafely() {
    // 判断是否为空 为空创建 否则返回
    if (null == instance) {
      instance = new Singleton3();
    }
    return instance;
  }

  // 3. 提供公共访问方法 双检 锁+volitae禁止指令重排 多线程安全
  public static Singleton3 getInstanceRealSafely() {
    // 判断是否为空 为空创建 否则返回
    if (null == instance) {
      synchronized (Singleton3.class) {
        if (null == instance) {
          instance = new Singleton3();
        }
      }
    }
    return instance;
  }
}
