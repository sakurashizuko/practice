package com.xjy.practice.design.设计模式.创建者模式.原型模式;

import com.xjy.practice.design.设计模式.创建者模式.原型模式.CloneEntity.DeepCloneEntity;
import com.xjy.practice.design.设计模式.创建者模式.原型模式.CloneEntity.ShallowCloneEntity;
import com.xjy.practice.design.设计模式.创建者模式.工厂模式.抽象工厂模式.product.impl.ApplePie;

public class CloneDemo {

  public static void main(String[] args) throws CloneNotSupportedException {
    ShallowCloneEntity shallowClone = new ShallowCloneEntity();
    shallowClone.setAge(13);
    shallowClone.setName("shadowClone");
    shallowClone.setApplePie(new ApplePie());
    ShallowCloneEntity cloneEntity =(ShallowCloneEntity) shallowClone.clone();
    System.out.println(shallowClone == cloneEntity);

    System.out.println(shallowClone.getApplePie());
    System.out.println(cloneEntity.getApplePie());

    DeepCloneEntity deepClone = new DeepCloneEntity();
    deepClone.setAge(13);
    deepClone.setName("deepClone");
    deepClone.setApplePie(new ApplePie());
    DeepCloneEntity deepClone1 =(DeepCloneEntity) deepClone.clone();
    System.out.println(deepClone == deepClone1);
    System.out.println(deepClone.equals( deepClone1));

    System.out.println(deepClone.getApplePie());
    System.out.println(deepClone1.getApplePie());



  }
}
