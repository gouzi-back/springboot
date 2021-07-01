package com.bootjdbc.demo.pojo;

import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 登录类
 * @date2021/4/24 11:01
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer uid;
    private String userName;
    private String password;
    private String realName;
}
