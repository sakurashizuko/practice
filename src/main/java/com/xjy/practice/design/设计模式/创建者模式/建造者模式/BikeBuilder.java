package com.xjy.practice.design.设计模式.创建者模式.建造者模式;

/**
 * 抽象构建者类
 *
 * @author mac
 */
public abstract class BikeBuilder {

  protected Bike bike = new Bike();


  public abstract void buildFrame();

  public abstract void buildSeat();

  public abstract void setBrand();
}
