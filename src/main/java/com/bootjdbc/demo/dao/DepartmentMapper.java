package com.bootjdbc.demo.dao;

import com.bootjdbc.demo.pojo.Department;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DepartmentMapper {
    List<Department> listAll();
}
