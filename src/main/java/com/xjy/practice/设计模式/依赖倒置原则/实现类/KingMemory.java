package com.xjy.practice.设计模式.依赖倒置原则.实现类;

import com.xjy.practice.设计模式.依赖倒置原则.接口.Memory;

public class KingMemory implements Memory {

  @Override
  public void save(String data) {
    System.out.println("KingMemory" + data);
  }
}
