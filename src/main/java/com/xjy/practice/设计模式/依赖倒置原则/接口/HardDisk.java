package com.xjy.practice.设计模式.依赖倒置原则.接口;

public interface HardDisk {

  static void main(String[] args) {
    System.out.println(1);
  }

  /**
   * 存储
   *
   * @param data data
   */
  void storage(String data);

  /**
   * read
   */
  String read();
}
