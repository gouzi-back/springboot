package com.bootjdbc.demo.pojo;/**
 * @Auther:haha
 * @Date:2021/4/23 - 04 - 23 15:42
 * @Description:com.hyy.pojo
 * @Version: 1.0
 */

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelEntity;
import cn.afterturn.easypoi.excel.annotation.ExcelIgnore;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

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
@ExcelTarget("employee")
public class Employee {
    @Excel(name = "员工id*" ,width = 10)
    private Integer id;
    @Excel(name = "员工姓名*",width = 20)
    private String lastName;
    @Excel(name = "性别*",replace = { "男_1", "女_0" },width = 10)
    private Integer gender;
    @ExcelEntity
    private Department department;
    @Excel(name = "员工email*",width = 30 ,height = 60,type = 2)
    private String email;
    @Excel(name = "日期*",width = 30,databaseFormat = "yyyyMMddHHmmss",format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birth;
    @ExcelIgnore
    private Integer demtId;


}
