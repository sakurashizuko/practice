package com.xjy.practice.design.设计模式.创建者模式.单例模式;

import org.junit.Assert;

public class Test {

  public static void main(String[] args) {
//    testSingleton1();
//    testSingleton2();
//    testSingleton3();
    testSingleton4();
    testSingleton5();
  }
  public static void testSingleton5() {
    Singleton5 instance = Singleton5.INSTANCE;
    Singleton5 instance2 = Singleton5.INSTANCE;
    Assert.assertEquals(instance, instance2);
  }
  public static void testSingleton4() {
    Singleton4 instance = Singleton4.getInstance();
    System.out.println("ssss");
    Singleton4 instance2 = Singleton4.getInstance();
    Assert.assertEquals(instance, instance2);


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

  public static void testSingleton1() {
    //
    Singleton instance = Singleton.getInstance();
    Singleton instance2 = Singleton.getInstance();
    assert instance == instance2;
  }
}
