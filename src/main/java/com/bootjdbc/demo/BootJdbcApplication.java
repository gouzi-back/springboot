package com.bootjdbc.demo;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class BootJdbcApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootJdbcApplication.class, args);
    }

}
