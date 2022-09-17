package com.xjy.practice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xjy.practice.mapper.UserMapper;
import com.xjy.practice.model.RUser;
import com.xjy.practice.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, RUser> implements UserService {


}
