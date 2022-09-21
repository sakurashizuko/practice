package com.xjy.practice.design.设计模式.创建者模式.建造者模式;

/**
 * @author mac
 */
public class OfoBikeBuilder extends BikeBuilder {

  @Override
  public void buildFrame() {
    bike.setFrame("OfoBikeFrame");
  }

  @Override
  public void buildSeat() {
    bike.setSeat("ofoseat");

  }

  @Override
  public void setBrand() {
    bike.setBrand("ofobrand");
  }
}
