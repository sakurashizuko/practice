package com.xjy.practice.设计模式.设计原则.迪米特法则.接口隔离原则;

public class MySafeDoor2 implements AntiTheftDoor, FireProofDoor {

  @Override
  public void fireProof() {
  }

  @Override
  public void antiTheft() {
  }
}
