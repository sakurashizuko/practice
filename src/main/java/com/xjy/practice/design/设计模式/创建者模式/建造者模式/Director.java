package com.xjy.practice.design.设计模式.创建者模式.建造者模式;

public class Director {

  private BikeBuilder bikeBuilder;

  public Director(BikeBuilder bikeBuilder) {
    this.bikeBuilder = bikeBuilder;
  }


  public Bike construct() {
    bikeBuilder.buildFrame();
    bikeBuilder.buildSeat();
    bikeBuilder.setBrand();
    return bikeBuilder.bike;
  }
}
