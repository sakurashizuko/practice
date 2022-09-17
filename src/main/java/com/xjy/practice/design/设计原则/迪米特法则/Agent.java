package com.xjy.practice.design.设计原则.迪米特法则;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Agent {

  private String name;
  private Company company;
  private Star star;
  private Fans fans;

  public void meeting() {
    System.out.println("通过" + name + star.getName() + "见到了" + fans.getName());
  }

  public void business() {
    System.out.println("通过" + name + star.getName() + "开始做生意和" + company.getName());
  }
}
