package com.xjy.practice.design.设计模式.创建者模式.建造者模式;

/**
 * @author mac
 */
public class HaloBikeBuilder extends BikeBuilder {

  @Override
  public void buildFrame() {
    bike.setFrame("HaloBikeframeName");
  }

  @Override
  public void buildSeat() {
    bike.setSeat("HaloBikeseat");

  }

  @Override
  public void setBrand() {
    bike.setBrand("HaloBikebrand");


  }
}
