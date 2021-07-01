package com.bootjdbc.demo.dao;

import com.bootjdbc.demo.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface EmployeeMapper {
    //查询全部
    List<Employee> listAll();

    //新增一个员工
    int add(Employee employee);

    //通过id获得员工信息
    Employee listAllById(Integer id);

    //通过id删除员工
    int delete(Integer id);

    //update
    int update(Employee employee);
}
