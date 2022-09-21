package com.xjy.practice.design.设计模式.创建者模式.原型模式;


import com.xjy.practice.design.设计模式.创建者模式.工厂模式.抽象工厂模式.product.impl.ApplePie;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

public class CloneEntity {

  /**
   *浅克隆
   * 对于浅克隆来说，一般的步骤如下：
   *
   * 1.被克隆的类需要实现Cloneable接口,这个接口是一个标记接口
   *
   * 2.覆盖clone方法，访问权限设置为public。在方法中调用super.clone()方法得到需要复制的对象。
   */
  @Getter
  @Setter
  static class ShallowCloneEntity  implements Cloneable  {

    private Integer age;
    private String name;
    private ApplePie applePie;
    @Override
    protected Object clone() throws CloneNotSupportedException {
      return super.clone();
    }
  }

  /**
   * 深克隆
   * 1.被克隆的类和聚合类一样实现覆盖自己的clone方法
   * 2.修改被克隆的类的clone方法，使其能够复制引用变量
   */
  @Getter
  @Setter
  static class DeepCloneEntity implements Cloneable {

    private Integer age;
    private String name;
    private ApplePie applePie;

    @Override
    protected Object clone() throws CloneNotSupportedException {
      DeepCloneEntity clone = (DeepCloneEntity) super.clone();
      ApplePie pie = (ApplePie) applePie.clone();
      clone.setApplePie(pie);
      return clone;


    }
  }
}