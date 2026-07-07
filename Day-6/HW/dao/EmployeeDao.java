package com.coforge.ems.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.coforge.ems.model.Employee;
import com.coforge.ems.util.ApplicationProperties;
import com.coforge.ems.util.DBUtil;

public class EmployeeDao {
	private static final List List = null;
	public int createEmployee(Employee employee) throws ClassNotFoundException, SQLException {
		int n = 0;
		Connection connection = DBUtil.getDBConnection();


		PreparedStatement statement = connection.prepareStatement(ApplicationProperties.insert);
		statement.setInt(1, employee.getEid());
		statement.setString(2, employee.getEname());
		statement.setInt(3, employee.getEsalary());
		statement.setInt(4, employee.getDno());

		n = statement.executeUpdate();
		return n;
	}

	public Employee findEmployee(int empid) throws ClassNotFoundException, SQLException {
		Connection connection = DBUtil.getDBConnection();
        
		
		PreparedStatement statement = connection.prepareStatement(ApplicationProperties.findEmployee);
		statement.setInt(1,empid);

		ResultSet resultset1 = statement.executeQuery();
		
		Employee employee = null;
		
		if(resultset1.next()) {
			employee = new Employee();
			employee.setEid(resultset1.getInt("eid"));
			employee.setEname(resultset1.getString("ename"));
			employee.setEsalary(resultset1.getInt("esalary"));
			employee.setDno(resultset1.getInt("dno"));
			
			
		}
		return employee ;
	}

	public int updateSalary(int empid, int salary) throws ClassNotFoundException, SQLException {
		int n = 0;
		Connection connection = DBUtil.getDBConnection();
		
		PreparedStatement statement = connection.prepareStatement(ApplicationProperties.updateSalary);
		statement.setInt(1, salary);
		statement.setInt(2, empid);

		n = statement.executeUpdate();
		return n;
	}
	public int updateDepartmentNumber(int empid, int deptno) throws ClassNotFoundException, SQLException {
		int n = 0;
		Connection connection = DBUtil.getDBConnection();

	
		PreparedStatement statement = connection.prepareStatement(ApplicationProperties.updateDeptNo);
		statement.setInt(1, deptno);
		statement.setInt(2, empid);

		n = statement.executeUpdate();
		return n;
	}
	
	public int delete(int empid) throws ClassNotFoundException, SQLException {
		int n = 0;
		Connection connection = DBUtil.getDBConnection();

		PreparedStatement statement = connection.prepareStatement(ApplicationProperties.delete);
		statement.setInt(1, empid);

		n = statement.executeUpdate();
		return n;
	}
	public List<Employee> findAll() throws ClassNotFoundException, SQLException {
		Connection connection = DBUtil.getDBConnection();

		PreparedStatement statement = connection.prepareStatement(ApplicationProperties.findAll);
		
		ResultSet resultset = statement.executeQuery();
		List<Employee> employeeList = new ArrayList<>();
		
		while(resultset.next()) {
			Employee employee = new Employee();
			employee.setEid(resultset.getInt("eid"));
			employee.setEname(resultset.getString("ename"));
			employee.setEsalary(resultset.getInt("esalary"));
			employee.setDno(resultset.getInt("dno"));
			
			employeeList.add(employee);
		}
		return employeeList;
	}
}
