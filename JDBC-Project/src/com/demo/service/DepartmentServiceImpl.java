package com.demo.service;

import java.util.List;

import com.demo.daoimpl.DepartmentDAOImpl;
import com.demo.model.Department;
import com.demo.DAO.DepartmentDAO;

public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentDAO dao = new DepartmentDAOImpl();

    @Override
    public int addDepartment(Department department) {
        return dao.addDepartment(department);
    }

    @Override
    public Department getDepartmentById(int id) {
        return dao.getDepartmentById(id);
    }

    @Override
    public List<Department> getAllDepartments() {
        return dao.getAllDepartments();
    }

    @Override
    public int updateDepartmentById(int id, String newName, String newLocation) {
        return dao.updateDepartmentById(id, newName, newLocation);
    }

    @Override
    public void deleteDepartment(int id) {
        dao.deleteDepartment(id);
    }

	
}
