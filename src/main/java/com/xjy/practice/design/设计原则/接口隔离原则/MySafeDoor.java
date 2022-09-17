package com.xjy.practice.design.设计原则.接口隔离原则;

public class MySafeDoor implements SaftyDoor {

  @Override
  public void antiTheft() {

    System.out.println("MySafeDoorantiTheft");
  }

  @Override
  public void fireProof() {
    System.out.println("MySafeDoorfireProof");
  }

  @Override
  public void waterProof() {
    System.out.println("MySafeDoorwaterProof");
  }

  public void run() {
    waterProof();
    fireProof();
    antiTheft();
  }
}
