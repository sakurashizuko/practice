package com.xjy.practice.design.设计模式.创建者模式.工厂模式;

import lombok.Data;

@Data
public class Moka extends Coffee {

  @Override
  public void printName() {
    System.out.println("Moka");
  }

}
