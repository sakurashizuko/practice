package com.xjy.practice.design.设计模式.创建者模式.工厂模式;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author mac
 */

@AllArgsConstructor
@Getter
public enum CoffeeTypeEnum {
  /**
   * 美式咖啡
   */
  ICED_AMERICANO(CafeAmericano.class),
  /**
   * 拿铁咖啡
   */
  COFFEE_LATTE(CoffeeLatte.class),
  /**
   * 拿铁咖啡
   */
  MOCHA(Moka.class);

  private final Class<? extends Coffee> typeClass;

}
