package com.xjy.practice.design.设计模式.创建者模式.单例模式;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import org.apache.commons.codec.Charsets;

public class Test1 {

  public static void main(String[] args) throws IOException {
    Runtime runtime = Runtime.getRuntime();
    Process exec = runtime.exec("ifconfig");
    InputStream inputStream = exec.getInputStream();
    byte[] bytes = new byte[1034 * 10034];
    int read = inputStream.read(bytes);
    String s = new String(bytes, Charsets.UTF_8);
    System.err.println(s);

  }
}
