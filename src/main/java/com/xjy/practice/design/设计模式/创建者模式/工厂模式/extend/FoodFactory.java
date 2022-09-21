package com.xjy.practice.design.设计模式.创建者模式.工厂模式.extend;

import com.xjy.practice.design.设计模式.创建者模式.工厂模式.抽象工厂模式.product.Dessert;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@PropertySource("bean.properties")
@Configuration
public class FoodFactory {

  //  1. 定义容器存储对象
  private static HashMap<String, Dessert> map = new HashMap<>();
 ArrayList a= new ArrayList();

  //2. 加载配置文件并配置进容器(只需要加载一次所以卸载静态代码块中)
  static {
    Properties properties = new Properties();
    InputStream inputStream = FoodFactory.class.getClassLoader()
        .getResourceAsStream("bean.properties");
    try {
      properties.load(inputStream);
      for (Object o : properties.keySet()) {
        String clazz = properties.getProperty((String) o);
        Class americanClazz = Class.forName(clazz);
        Dessert newInstance = (Dessert) americanClazz.newInstance();
        map.put((String) o, newInstance);
      }
    } catch (IOException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
      e.printStackTrace();
    }

  }


  public static void main(String[] args) {

    Dessert dessert = map.get("american");
    dessert.printCalorie();

  }
}
