package com.xjy.practice.design.设计原则.依赖倒置原则.实现类;

import com.xjy.practice.design.设计原则.依赖倒置原则.接口.Memory;

public class KingMemory implements Memory {

  @Override
  public void save(String data) {
    System.out.println("KingMemory" + data);
  }
}
