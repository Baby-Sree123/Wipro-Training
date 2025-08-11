package com.demo.service;

import java.util.List;
import com.demo.model.Department;

public interface DepartmentService {

    int addDepartment(Department department);
    Department getDepartmentById(int id);
    List<Department> getAllDepartments();
    int updateDepartmentById(int id, String newName, String newLocation);
    void deleteDepartment(int id);
}
