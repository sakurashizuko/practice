package com.xjy.practice;

import com.xjy.practice.config.MyCondition;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.context.annotation.Conditional;

/**
 * @author mac
 */

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Conditional(MyCondition.class)
public @interface ConditionalOnClass {

  String value();
}
