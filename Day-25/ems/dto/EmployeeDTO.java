package com.coforge.ems.dto;

import com.coforge.ems.model.Employee;

public class EmployeeDTO {

	private Employee employee;
	
	private DepartmentDTO department;

	public EmployeeDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployeeDTO(Employee employee, DepartmentDTO department) {
		super();
		this.employee = employee;
		this.department = department;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public DepartmentDTO getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentDTO department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "EmployeeDTO [employee=" + employee + ", department=" + department + "]";
	}

	
	
}