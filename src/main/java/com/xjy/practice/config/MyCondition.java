package com.xjy.practice.config;

import com.xjy.practice.ConditionalOnClass;
import java.util.Map;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class MyCondition implements Condition {

  @Override
  public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

    Map<String, Object> objectMap = metadata.getAnnotationAttributes(
        ConditionalOnClass.class.getName());
    String className = (String) objectMap.get("value");
    try {
      context.getClassLoader().loadClass(className);
      return true;
    } catch (ClassNotFoundException e) {
      return false;
    }
  }
}
