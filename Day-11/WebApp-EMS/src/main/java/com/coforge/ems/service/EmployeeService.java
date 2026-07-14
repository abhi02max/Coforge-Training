package com.coforge.ems.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.coforge.ems.dao.EmployeeDAO;
import com.coforge.ems.exception.InvalidEmployeeObjectException;
import com.coforge.ems.model.Employee;

public class EmployeeService {

	private EmployeeDAO dao = new EmployeeDAO();

	public int createEmployee(Employee employee)
			throws ClassNotFoundException, SQLException, InvalidEmployeeObjectException {

		int n = 0;

		if (employee != null && employee.getEid() > 0 && employee.getEname() != null && employee.getEsalary() > 0) {

			n = dao.createEmployee(employee);

		} else {
			throw new InvalidEmployeeObjectException();
		}

		return n;
	}
	public int updateEmployee(Employee employee) throws ClassNotFoundException, SQLException, InvalidEmployeeObjectException {
		int n = 0;
		int id = employee.getEid();
		if(id > 0) {
			n = dao.updateEmployee(employee);
		}
		else {
			throw new InvalidEmployeeObjectException();
		}
		return n;
	}

	public int deleteEmployee(int id) throws ClassNotFoundException, SQLException, InvalidEmployeeObjectException {

		int n = 0;

		if (id <= 0) {
			throw new InvalidEmployeeObjectException();
		}

		n = dao.deleteEmployee(id);

		if (n == 0) {
			throw new InvalidEmployeeObjectException();
		}

		return n;
	}

	public Employee showEmployee(int id) throws ClassNotFoundException, SQLException, InvalidEmployeeObjectException {

		if (id <= 0) {
			throw new InvalidEmployeeObjectException();
		}

		Optional<Employee> optionalEmployee = dao.showEmployee(id);

		if (optionalEmployee.isPresent()) {
			return optionalEmployee.get();
		} 
		 
		return null;
		//else {
		//	throw new InvalidEmployeeObjectException();
		//}
	}

	public List<Employee> showAllEmployees()
			throws ClassNotFoundException, SQLException, InvalidEmployeeObjectException {

		Optional<List<Employee>> optionalEmployeeList = dao.showAllEmployees();

		if (optionalEmployeeList.isPresent()) {
			return optionalEmployeeList.get();
		} else {
			throw new InvalidEmployeeObjectException();
		}
	}
}