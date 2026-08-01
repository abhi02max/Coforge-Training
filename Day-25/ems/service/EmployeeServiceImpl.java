package com.coforge.ems.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coforge.ems.dto.DepartmentDTO;
import com.coforge.ems.exception.EmployeeNotFoundException;
import com.coforge.ems.model.Employee;
import com.coforge.ems.repo.EmployeeRepo;
import com.coforge.ems.service.client.DepartmentClient;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepo repo;
	private Environment environment;
	private DepartmentClient client;

	@Autowired
	public EmployeeServiceImpl(EmployeeRepo repo, Environment environment, DepartmentClient client) {
		super();
		this.repo = repo;
		this.environment = environment;
		this.client = client;
	}

	@Override
	public boolean saveEmployee(Employee employee) {
		repo.save(employee);
		return true;
	}

	@Override
	public boolean UpdateEmployee(int eid, Employee employee) {
		if (!repo.existsById(eid)) {
			throw new EmployeeNotFoundException(environment.getProperty("ems.invalid.employee-notFound"));
		}
		repo.save(employee);
		return true;
	}

	@Override
	public boolean deleteEmployee(int eid) {
		if (!repo.existsById(eid)) {
			throw new EmployeeNotFoundException(environment.getProperty("ems.invalid.employee-notFound"));
		}
		repo.deleteById(eid);
		return true;
	}

	@Override
	public Optional<Employee> findEmployee(int eid) {
		if (!repo.existsById(eid)) {
			throw new EmployeeNotFoundException(environment.getProperty("ems.invalid.employee-notFound"));
		}
		Optional<Employee> employee = repo.findById(eid);
		return employee;
	}

	@Override
	public List<Employee> findAllEmployee() {

		return (List<Employee>) repo.findAll();
	}

//
	@Override
	public List<Employee> findByEname(String ename) {
		List<Employee> employees = repo.findByEname(ename);
		if (employees.isEmpty()) {
			throw new EmployeeNotFoundException(environment.getProperty("ems.invalid.employee-notFound"));
		}
		return employees;

	}

//
	@Override
	@Transactional // when Modifies the database
	public boolean deleteByEname(String ename) {

		int n = repo.deleteByEname(ename);
		if (n == 0) {
			throw new EmployeeNotFoundException(environment.getProperty("ems.invalid.employee-notFound"));
		}
		return true;
	}
//
	@Override
	public List<Integer> getEidsList() {
		List<Integer> eids = repo.getEids();
		return eids;
	}
//
//	@Override
//	public String getInfoList() {
//		String info = repo.getInfo();
//		return info;
//	}

	@Override
	public DepartmentDTO findDepartmentById(int dno) {
		DepartmentDTO department = client.getDepartmentById(dno);
		return department;
	}

	@Override
	public List<DepartmentDTO> findAllDepartments() {
		List<DepartmentDTO> departments = client.getDepartments();
		return departments;
	}

}
