package com.bootjdbc.demo.service.impl;

import com.bootjdbc.demo.dao.EmployeeMapper;
import com.bootjdbc.demo.pojo.Employee;
import com.bootjdbc.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hh
 * @date2021/4/27 10:55
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;
    @Override
    public List<Employee> listAll() {
        return employeeMapper.listAll();
    }

    @Override
    public int add(Employee employee) {
        return employeeMapper.add(employee);
    }

    @Override
    public Employee listAllById(Integer id) {
        return employeeMapper.listAllById(id);
    }

    @Override
    public int delete(Integer id) {
        return employeeMapper.delete(id);
    }

    @Override
    public int update(Employee employee) {
        return employeeMapper.update(employee);
    }
}
