package com.bootjdbc.demo.pojo;/**
 * @Auther:haha
 * @Date:2021/4/23 - 04 - 23 15:42
 * @Description:com.hyy.pojo
 * @Version: 1.0
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Employee
 * <功能详细描述>
 *
 * @author haha
 * @version [版本号, 2021/4/23 15:42]
 * @see  员工表
 * @since [产品/模块版本]
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private Integer id;
    private String lastName;
    private String email;
    private Integer gender;
    private Department department;
    private Date birth;
    private Integer demtId;


}
