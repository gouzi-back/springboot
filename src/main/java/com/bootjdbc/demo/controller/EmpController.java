package com.bootjdbc.demo.controller;/**
 * @Auther:haha
 * @Date:2021/4/25 - 04 - 25 22:53
 * @Description:com.hyy.controller
 * @Version: 1.0
 */


import com.bootjdbc.demo.pojo.Department;
import com.bootjdbc.demo.pojo.Employee;
import com.bootjdbc.demo.service.impl.DepartmentServiceImpl;
import com.bootjdbc.demo.service.impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;
import java.util.List;

/**
 * EmpController
 * <功能详细描述>
 *
 * @author 员工管理
 * @version [版本号, 2021/4/25 22:53]
 * @see  [相关类/方法]
 * @since [产品/模块版本]
 */
@Controller
public class EmpController {

    @Autowired
    EmployeeServiceImpl employeeService;
    @Autowired
    DepartmentServiceImpl departmentService;

    @RequestMapping("/emps")
    public String list(Model model){
        List<Employee> employees= employeeService.listAll();
        model.addAttribute("employees",employees);
        return "emp/list";
    }

    @RequestMapping("/emp")
    public String toAdd(Model model){

        //查出所有部门的信息
       List<Department> department= departmentService.listAll();
       model.addAttribute("department",department);
        return "emp/add";
    }

    @RequestMapping("/add")
    public String Add(Employee employee){
        //进行添加的操作
        employeeService.add(employee);
        return "redirect:/emps";
    }

    @RequestMapping("/toUpdate/{id}")
    public String toUpdate(@PathVariable("id") Integer id, Model model){

        Employee employeeById =employeeService.listAllById(id);
        model.addAttribute("employeeById",employeeById);

        //查出所有部门的信息
        List<Department> department= departmentService.listAll();
        model.addAttribute("department",department);

        return "emp/update";
    }
    @RequestMapping("/update")
    public String update(Employee employee){
        employeeService.update(employee);
        return "redirect:/emps";
    }

    @RequestMapping("/del/{id}")
    public String Del(@PathVariable("id") Integer id){
        employeeService.delete(id);
        return "redirect:/emps";
    }

}
