package com.xjy.practice.design.设计原则.接口隔离原则;


public class MySafeDoor2 implements AntiTheftDoor, FireProofDoor {

  @Override
  public void fireProof() {
  }

  @Override
  public void antiTheft() {
  }
}
