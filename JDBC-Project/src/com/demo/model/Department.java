package com.demo.model;

public class Department {
	
	private int deptId;
	private String deptName;
	private String location;
	private String managerName;
	private int noOfEmployees;
	
	
	public Department() {
		
	}
	
	
	public Department(int deptId, String deptName, String location, String managerName, int noOfEmployees) {
		//super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.location = location;
		this.managerName = managerName;
		this.noOfEmployees = noOfEmployees;
	}
	
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public int getNoOfEmployees() {
		return noOfEmployees;
	}
	public void setNoOfEmployees(int noOfEmployees) {
		this.noOfEmployees = noOfEmployees;
	}
	
	
	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", deptName=" + deptName + ", location=" + location + ", managerName="
				+ managerName + ", noOfEmployees=" + noOfEmployees + "]";
	}
	
	
	
	
	

}
