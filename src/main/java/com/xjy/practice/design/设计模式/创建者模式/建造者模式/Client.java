package com.xjy.practice.design.设计模式.创建者模式.建造者模式;

/**
 * 使用不同的品牌的吉祥
 */
public class Client {

  public static void main(String[] args) {
    Director director = new Director(new HaloBikeBuilder());
    Bike construct = director.construct();
    System.out.println(construct);

  }
}
