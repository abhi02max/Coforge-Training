package com.coforge.ems.util;

public class ApplicationProperties {

	// purpose of Application Properties - to store all literals as static constant
	// Database Properties
	public static String driver = "com.mysql.cj.jdbc.Driver";
	public static String url = "jdbc:mysql://localhost:3306/mydatabase";
	public static String username = "root";
	public static String password = "admin";

	// SQL Queries
	public static String insert = "insert into tbl_employee values (?,?,?,?)";
	public static final String update = "update tbl_employee set ename = ?, esalary = ?, dno = ? where eid = ?";
//    public static final String updateID = "update tbl_employee set eid = ? where eid = ?";
//    public static final String updateName = "update tbl_employee set ename = ? where eid = ?";
//    public static final String updateSalary = "update tbl_employee set esalary = ? where eid = ?";
//    public static final String updateDno = "update tbl_employee set dno = ? where eid = ?";
	public static final String delete = "delete from tbl_employee where eid = ?";
	public static final String findOne = "select * from tbl_employee where eid = ?";
	public static final String findAll = "select * from tbl_employee";

	// Application Response Messages
	public static final String insertSuccess = "SUCCESS : Employee Record Inserted";
	public static final String updateSuccess = "SUCCESS : Employee Record Updated";
	public static final String deleteSuccess = "SUCCESS : Employee Record Deleted";
	public static final String DBfail = "FAILED : DB Failed";
	public static final String notFound = "FAILED : Record not found";

}