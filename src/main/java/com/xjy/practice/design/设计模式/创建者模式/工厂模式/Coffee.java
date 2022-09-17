package com.xjy.practice.design.设计模式.创建者模式.工厂模式;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public abstract class Coffee {

public  abstract String getName();
  public void addSugar() {

    System.out.println("CoffeeaddSugar ");
  }

  public void addMilk() {
    System.out.println("Coffee addMilk");

  }
}
