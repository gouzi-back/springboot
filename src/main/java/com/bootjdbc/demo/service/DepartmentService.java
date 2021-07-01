package com.bootjdbc.demo.service;

import com.bootjdbc.demo.pojo.Department;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface DepartmentService {
    List<Department> listAll();
}
