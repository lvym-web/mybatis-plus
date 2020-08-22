package com.lvym.mybatisplus.server.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lvym.mybatisplus.dao.UserMapper;
import com.lvym.mybatisplus.entity.User;
import com.lvym.mybatisplus.server.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {
}
