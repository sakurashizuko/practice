package com.xjy.practice.design.设计模式.创建者模式.单例模式;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TestBreakSingleton {

  public static void main(String[] args) throws Exception {

//    往文件中写对象
    writeObject2File();
//    从文件中读取对象
    Singleton4 s1 = readObjectFromFile();
    System.out.println(s1);
    Singleton4 s2 = readObjectFromFile();
    System.err.println(s2);
//    判断两个反序列化后的对象是否是同一个对象
    System.out.println(s1 == s2);
  }

  private static Singleton4 readObjectFromFile()
      throws Exception {
//    创建对象输入流对象
    ObjectInputStream
        ois = new ObjectInputStream(
        new FileInputStream("/Users/mac/Downloads/mengniu/code/practice/a.txt"));
//    第一个读取Singleton对象 Singleton5 枚举类不会有问题
    return (Singleton4) ois.readObject();
  }

  public static void writeObject2File() throws Exception {
//    获取Singleton类的对象
    Singleton4 instance = Singleton4.getInstance();
//    创建对象输出流
    ObjectOutputStream
        oos = new ObjectOutputStream(
        new FileOutputStream("/Users/mac/Downloads/mengniu/code/practice/a.txt"));
//    将instance对象写出到文件中
    oos.writeObject(instance);
  }
}

