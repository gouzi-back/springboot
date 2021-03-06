package com.bootjdbc.demo.service.impl;

import com.bootjdbc.demo.dao.UserMapper;
import com.bootjdbc.demo.pojo.Test;
import com.bootjdbc.demo.pojo.User;
import com.bootjdbc.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @authorsss
 * @date2021/4/27 9:28
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User login(String username, String password) {
        return userMapper.login(username,password);
    }

    @Override
    public int addtest(Test test) {
        return userMapper.addtest(test);
    }
}
