package com.bootjdbc.demo.dao;

import com.bootjdbc.demo.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


import java.util.List;

@Mapper
public interface UserMapper {
   //登录
    public User login(@Param("username")String username,@Param("password")String password);

}
