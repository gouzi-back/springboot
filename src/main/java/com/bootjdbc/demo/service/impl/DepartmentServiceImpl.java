package com.bootjdbc.demo.service.impl;

import com.bootjdbc.demo.dao.DepartmentMapper;
import com.bootjdbc.demo.pojo.Department;
import com.bootjdbc.demo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @authordd
 * @date2021/4/27 11:27
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    DepartmentMapper departmentMapper;

    @Override
    public List<Department> listAll() {
        return departmentMapper.listAll();
    }
}
