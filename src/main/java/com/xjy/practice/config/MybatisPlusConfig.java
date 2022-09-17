package com.xjy.practice.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 吴梓锋
 * @version 1.0.0
 * @date 2022/06/02 16:35:12
 * @description 分页插件
 */
@Configuration
public class MybatisPlusConfig {

  /**
   * 分页插件
   */
  @Bean
  public PaginationInterceptor paginationInterceptor() {
    return new PaginationInterceptor();
  }

}
