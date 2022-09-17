package com.xjy.practice.design.设计原则.依赖倒置原则;


import com.xjy.practice.design.设计原则.依赖倒置原则.实现类.IntelCpu;
import com.xjy.practice.design.设计原则.依赖倒置原则.实现类.KingMemory;
import com.xjy.practice.design.设计原则.依赖倒置原则.实现类.XjHardDisk;
import com.xjy.practice.design.设计原则.依赖倒置原则.接口.Cpu;
import com.xjy.practice.design.设计原则.依赖倒置原则.接口.Memory;

public class Test {

  public static void main(String[] args) {
    //
    com.xjy.practice.设计模式.依赖倒置原则.接口.HardDisk hardDisk = new XjHardDisk();
    Cpu cpu = new IntelCpu();
    Memory memory = new KingMemory();
    Computer computer = new Computer(hardDisk, cpu, memory);
    computer.run();
  }
}
