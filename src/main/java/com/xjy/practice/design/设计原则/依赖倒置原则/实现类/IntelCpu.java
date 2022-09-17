package com.xjy.practice.design.设计原则.依赖倒置原则.实现类;


import com.xjy.practice.design.设计原则.依赖倒置原则.接口.Cpu;

public class IntelCpu implements Cpu {

  @Override
  public void run() {

    System.out.println("hahahaIntelCpuh");
  }
}
