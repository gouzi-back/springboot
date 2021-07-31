package com.bootjdbc.demo.pojo;/**
 * @Auther:haha
 * @Date:2021/4/23 - 04 - 23 15:38
 * @Description:com.hyy.pojo
 * @Version: 1.0
 */

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 部门表
 * Department
 * <功能详细描述>
 *
 * @author 周宇峰
 * @version [版本号, 2021/4/23 15:38]
 * @see  [相关类/方法]
 * @since [产品/模块版本]
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ExcelTarget("department")
public class Department implements Serializable {

       private Integer id;
       @Excel(name = "部门")
       private String departmentName;
}
