package com.xjy.practice.设计模式.创建者模式.单例模式;

import org.junit.Assert;

public class Test {

  public static void main(String[] args) {
    testSingleton2();
    testSingleton3();
  }

  // 懒汉式  调用时才初始化，不占用空间 但是多线程不安全
  public static void testSingleton3() {
    Singleton3 instance = Singleton3.getInstance();
    Singleton3 instance2 = Singleton3.getInstance();
    Assert.assertNotEquals(instance, instance2);
  }

  // 饿汉式都是static 在类加载时期就将单例对象创建完成并存在在类中   浪费空间
  public static void testSingleton2() {
    Singleton2 instance = Singleton2.getInstance();
    Singleton2 instance2 = Singleton2.getInstance();
    Assert.assertNotEquals(instance, instance2);
  }

  public static void Singleton() {
    //
    Singleton instance = Singleton.getInstance();
    Singleton instance2 = Singleton.getInstance();
    assert instance == instance2;
  }
}
