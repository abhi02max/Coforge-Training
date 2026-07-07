package com.coforge.ems.util;

public class ApplicationProperties {
	// Database Constants
	public static final String driver = "com.mysql.cj.jdbc.Driver";
	public static final String url = "jdbc:mysql://localhost:3306/db_employee";
	public static final String root = "root";
	public static final String password = "Saud231005@";

	// Databse Sql queries
	public static final String insert = "insert into employee values(?, ?, ?, ?)";
	public static final String findAll = "select * from employee";
	public static final String findEmployee = "select eid,ename,esalary,dno from employee where eid = ? ";
	public static final String updateSalary = "update employee set esalary = ? where eid= ?";
	public static final String delete = "delete from employee where eid= ?";
	public static final String updateDeptNo = "update employee set dno = ? where eid= ?";

	// Application Response Properties
	public static final String insertSuccess = "Success : Employee Record Inserted";
	public static final String dbFailed = "Failed : DB ERROR";
	public static final String updateSucess = "Success : Employee Record Updated";
	public static final String deleteSuccess = "Success : Employee Record deleted";
	public static final String employeeNotFound = "Employee Not Found";

	// Application Validation Failed

	public static final String validationFailed = "Failed:Invalid Employee Details";
}
