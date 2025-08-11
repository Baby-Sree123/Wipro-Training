package com.demo.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.demo.DAO.DepartmentDAO;
import com.demo.model.Department;
import com.demo.util.DbUtil;

public class DepartmentDAOImpl implements DepartmentDAO {

	@Override
	public int addDepartment(Department department) {
	    Connection connection = DbUtil.getConnection();

	    String INSERT_DEPARTMENT_QUERY =
	        "INSERT INTO Department (deptId, deptName, location, managerName, noOfEmployees) VALUES (?, ?, ?, ?, ?)";

	    PreparedStatement prepareStatement = null;
	    int res = 0;
	    try {
	        prepareStatement = connection.prepareStatement(INSERT_DEPARTMENT_QUERY);

	        prepareStatement.setInt(1, department.getDeptId());
	        prepareStatement.setString(2, department.getDeptName());
	        prepareStatement.setString(3, department.getLocation());
	        prepareStatement.setString(4, department.getManagerName());
	        prepareStatement.setInt(5, department.getNoOfEmployees());

	         res = prepareStatement.executeUpdate();
	        System.out.println(res + " row(s) inserted.");
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (prepareStatement != null) {
	                prepareStatement.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
		return res;
	}


	@Override
	public Department getDepartmentById(int deptId) {
	    String GET_DEPARTMENT_QUERY = "SELECT * FROM department WHERE deptId = ?";

	    PreparedStatement prepareStatement = null;
	    Department department = null;
	    try {
	        Connection connection = DbUtil.getConnection();
	        prepareStatement = connection.prepareStatement(GET_DEPARTMENT_QUERY);

	        prepareStatement.setInt(1, deptId);
	        ResultSet res = prepareStatement.executeQuery();

	        if (res.next()) {
	            String deptName = res.getString("deptName");
	            String location = res.getString("location");
	            String managerName = res.getString("managerName");
	            int noOfEmployees = res.getInt("noOfEmployees");

	            department = new Department(deptId, deptName, location, managerName, noOfEmployees);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (prepareStatement != null) {
	                prepareStatement.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    return department;
	}


	
	@Override
	public List<Department> getAllDepartments() {
	    String sql = "SELECT * FROM department";
	    List<Department> departmentsList = new ArrayList<>();

	    try (
	        Connection connection = DbUtil.getConnection();
	        Statement statement   = connection.createStatement();
	        ResultSet rs          = statement.executeQuery(sql);
	    ) {
	        while (rs.next()) {
	            int deptId          = rs.getInt("deptId");
	            String deptName     = rs.getString("deptName");
	            String location     = rs.getString("location");
	            String managerName  = rs.getString("managerName");
	            int noOfEmployees   = rs.getInt("noOfEmployees");

	            Department dept = new Department(
	                deptId, deptName, location, managerName, noOfEmployees
	            );
	            departmentsList.add(dept);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return departmentsList;
	}


	@Override
	public int updateDepartmentById(int deptId, String newName, String newLocation) {
	    String UPDATE_DEPARTMENT_QUERY = 
	        "UPDATE department SET deptName = ?, location = ? WHERE deptId = ?";
	    
	    int rowsAffected = 0;

	    try (
	        Connection connection = DbUtil.getConnection();
	        PreparedStatement ps = connection.prepareStatement(UPDATE_DEPARTMENT_QUERY);
	    ) {
	        ps.setString(1, newName);
	        ps.setString(2, newLocation);
	        ps.setInt(3, deptId);

	        rowsAffected = ps.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return rowsAffected;
	}
	
	
	@Override
	public void deleteDepartment(int deptId) {
	    String DELETE_DEPARTMENT_QUERY = "DELETE FROM department WHERE deptId = ?";

	    try (
	        Connection connection = DbUtil.getConnection();
	        PreparedStatement prepareStatement = connection.prepareStatement(DELETE_DEPARTMENT_QUERY);
	    ) {
	        prepareStatement.setInt(1, deptId);
	        int rowsAffected = prepareStatement.executeUpdate();
	        if (rowsAffected > 0) {
	            System.out.println("Department deleted successfully.");
	        } else {
	            System.out.println("No department found with ID: " + deptId);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}


	

	
		
	
	

}
