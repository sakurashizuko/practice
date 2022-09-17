package com.xjy.practice.设计模式.设计原则.迪米特法则;

public class Client {

  public static void main(String[] args) {
    //
    Agent agent = new Agent("明星的经济公司", new Company("卖货的找代言"), new Star("一个小明星"), new Fans("他的大粉丝"));

    agent.meeting();
    agent.business();
  }
}
