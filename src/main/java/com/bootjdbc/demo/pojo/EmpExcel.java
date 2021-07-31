package com.bootjdbc.demo.pojo;/**
 * @Auther: hyy
 * @Date:2021/7/27 - 07 - 27 15:46
 * @Description:com.bootjdbc.demo.pojo
 * @Version: 1.0
 */

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.Data;

/**
 *@author
 *@date2021/7/27 15:46
 *
 *
 */
@ExcelTarget("EmpExcel")
@Data
public class EmpExcel  {

    @Excel(name = "员工姓名*")
    private String lastName;
    @Excel(name = "员工email*")
    private String email;

}
