package com.demo.DAO;

import java.util.List;

import com.demo.model.Department;

public interface DepartmentDAO {
	
	int addDepartment(Department department);
	Department getDepartmentById(int deptId);
	List<Department> getAllDepartments();
	int updateDepartmentById(int deptId, String newName, String newLocation);
	void deleteDepartment(int deptId);
	
	
	
	
	

}
