package com.xjy.practice.design.设计原则.依赖倒置原则.实现类;

import com.xjy.practice.设计模式.依赖倒置原则.接口.HardDisk;

public class XjHardDisk implements HardDisk {

  @Override
  public void storage(String data) {
    System.out.println("XijieHardDisk storage+" + data);
  }

  @Override
  public String read() {
    return "XijieHardDisk storage+";
  }
}
