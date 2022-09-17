package com.xjy.practice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xjy.practice.mapper.RUserWeightMapper;
import com.xjy.practice.model.RUserWeight;
import com.xjy.practice.service.UserWeightService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 */
@Slf4j
@Service
public class UserWeightServiceImpl extends ServiceImpl<RUserWeightMapper, RUserWeight>
    implements UserWeightService {

  @Autowired
  private RUserWeightMapper weightMapper;

  @Override
  public boolean testA() {
    log.info("testA");
    weightMapper.insertWeight(3, 120);
    int i = 1 / 0;

    boolean b = testB(139);
    System.out.println(b);
    return true;
  }

  @Transactional
  public boolean testB(Integer b) {
    log.info("testB");
    weightMapper.insertWeight(3, b);
    int i = 1 / 0;
    return true;
  }
}
