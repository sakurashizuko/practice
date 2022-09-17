package com.xjy.practice.设计模式.依赖倒置原则;

import com.xjy.practice.设计模式.依赖倒置原则.接口.Cpu;
import com.xjy.practice.设计模式.依赖倒置原则.接口.HardDisk;
import com.xjy.practice.设计模式.依赖倒置原则.接口.Memory;

/**
 * 创建计算机对象时如果换组件 无需修改成员变量类型 只需要拓展类型的实现类
 */
public class Computer {

  private HardDisk hardDisk;
  private Cpu cpu;
  private Memory memory;

  public Computer() {
  }

  public Computer(HardDisk hardDisk, Cpu cpu, Memory memory) {
    this.hardDisk = hardDisk;
    this.cpu = cpu;
    this.memory = memory;
  }

  public HardDisk getHardDisk() {
    return hardDisk;
  }

  public void setHardDisk(HardDisk hardDisk) {
    this.hardDisk = hardDisk;
  }

  public Cpu getCpu() {
    return cpu;
  }

  public void setCpu(Cpu cpu) {
    this.cpu = cpu;
  }

  public Memory getMemory() {
    return memory;
  }

  public void setMemory(Memory memory) {
    this.memory = memory;
  }

  public void run() {
    System.out.println("computer run");
    String read = hardDisk.read();
    hardDisk.storage(read + System.nanoTime());
    cpu.run();
    memory.save("hahahah" + System.nanoTime() + "");
  }
}
