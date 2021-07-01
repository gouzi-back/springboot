package com.bootjdbc.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Map;

/**
 * @author
 * springboo整合jdbc
 * @date2021/4/24 9:14
 */
@RestController
@RequestMapping("/jdbc")
public class JdBcController {

    @Autowired
    JdbcTemplate jdbcTemplate;
    //查询
    @GetMapping("/list")
    public List<Map<String,Object>> userList(){
        String sql="select * from user";
        List<Map<String,Object>> maps=jdbcTemplate.queryForList(sql);
        return maps;
    }

    //新增
    @GetMapping("/add")
    public String addUser(){
        String sql ="insert into user (`name`,age)" +
                "VALUES('hahah ',10)";
        jdbcTemplate.update(sql);
        //查询
        return  "addOK";
    }
    //修改
    @GetMapping("/update/{id}")
    public String updateUser(@PathVariable("id") int id){
        String sql ="update `user` set `name`=?,`age`=? where `id` ="+id;

        Object[] objects= new Object[2];
        objects[0]="啦啦";
        objects[1]=2;
       // jdbcTemplate.update(sql,objects);
        int a= jdbcTemplate.update(sql,objects);
        //查询
        if (a==0)
            return "updateNo";
        return  "updaetOK";
    }
    //删除
    @GetMapping("/delete/{id}")
    public String delUser(@PathVariable("id") int id){
        String sql = "delete from user where id="+id;
        jdbcTemplate.update(sql);
        //查询
        return  "deleteOK";
    }
}
