package com.bootjdbc.demo.service;


import com.bootjdbc.demo.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {

    //登录
    public User login(String username, String password);
}
