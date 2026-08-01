package com.coforge.ems.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coforge.ems.dto.DepartmentDTO;
import com.coforge.ems.dto.EmployeeDTO;
import com.coforge.ems.model.Employee;
import com.coforge.ems.service.EmployeeService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@RestController
@RequestMapping("api/v1/ems")
@CrossOrigin(origins = "http://localhost:4200/")
public class EmployeeController {

//	@GetMapping("/welcome")
//	public String sayWelcome() {
//		return "Welcome to EMS";
//	}

	// @Autowired //Field injection
	private EmployeeService service;
	private Environment environment;

	@Autowired // Constructor injection
	public EmployeeController(EmployeeService service, Environment environment) {
		super();
		this.service = service;
		this.environment = environment;
	}

	@PostMapping("/employees")
	public ResponseEntity<String> saveEmployee(@NotNull @Valid @RequestBody(required = false) Employee employee) {
		System.out.println("Inside Post");
		ResponseEntity<String> responseEntity = null;

		boolean status = service.saveEmployee(employee);
		if (status) {
			responseEntity = new ResponseEntity<>(environment.getProperty("ems.save.success"), HttpStatus.CREATED);
		}
		return responseEntity;
	}

	@PutMapping("/employees/{eid}")
	public ResponseEntity<String> UpdateEmployee(@PathVariable("eid") int eid,
			@Valid @NotNull @RequestBody Employee employee) {
		ResponseEntity<String> responseEntity = null;

		boolean status = service.UpdateEmployee(eid, employee);
		if (status) {
			responseEntity = new ResponseEntity<>(environment.getProperty("ems.update.success"), HttpStatus.CREATED);
		}
		return responseEntity;
	}

	@DeleteMapping("/employees/{eid}")
	public ResponseEntity<String> DeleteEmployee(@PathVariable("eid") int eid) {
		ResponseEntity<String> responseEntity = null;

		boolean status = service.deleteEmployee(eid);
		if (status) {
			responseEntity = new ResponseEntity<>(environment.getProperty("ems.delete.success"), HttpStatus.CREATED);
		}
		return responseEntity;
	}
	
	@GetMapping("/employees/{eid}")
	public ResponseEntity<Employee> FindEmployee(@PathVariable("eid") int eid) {
		ResponseEntity<Employee> responseEntity = null;

		Optional<Employee> employee = service.findEmployee(eid);
		if (employee!=null) {
			responseEntity = new ResponseEntity<>(employee.get(), HttpStatus.CREATED);
		}
		return responseEntity;
	}

	@GetMapping("/employees")
	public ResponseEntity<?> FindAllEmployee() {
		ResponseEntity<?> responseEntity = null;

		List<Employee> employees = service.findAllEmployee();
		responseEntity = new ResponseEntity<>(employees, HttpStatus.CREATED);
		return responseEntity;
	}

//  
	@GetMapping("/employees/ename/{ename}")
	public ResponseEntity<?> findByEname(@PathVariable("ename") String ename) {
		ResponseEntity<?> responseEntity = null;

		List<Employee> emp = service.findByEname(ename);
		responseEntity = new ResponseEntity<>(emp, HttpStatus.CREATED);
		return responseEntity;
	}

	@DeleteMapping("/employees/ename/{ename}")
	public ResponseEntity<String> DeleteByEname(@PathVariable("ename") String ename) {
		ResponseEntity<String> responseEntity = null;

		boolean status = service.deleteByEname(ename);
		if (status) {
			responseEntity = new ResponseEntity<>(environment.getProperty("ems.delete.success"), HttpStatus.CREATED);
		}
		return responseEntity;
	}

//
	@GetMapping("/employees/eids")
	public ResponseEntity<?> getEidsList() {

		ResponseEntity<?> responseEntity = null;
		List<Integer> eids = service.getEidsList();
		responseEntity = new ResponseEntity<>(eids, HttpStatus.OK);
		return responseEntity;
	}
//
//	@GetMapping("/employees/info")
//	public ResponseEntity<?> getInfoList() {
//
//		ResponseEntity<?> responseEntity = null;
//		try {
//			String info = service.getInfoList();
//			responseEntity = new ResponseEntity<>(info, HttpStatus.OK);
//		} catch (Exception e) {
//			responseEntity = new ResponseEntity<>(environment.getProperty("ems.db.failed"), HttpStatus.BAD_REQUEST);
//		}
//		return responseEntity;
//	}

	// Rest end points for feign client department
	@GetMapping("/employees/departments/{dno}")
	public ResponseEntity<?> findDepartmentById(@PathVariable int dno) {
		ResponseEntity<?> responseEntity = null;
		DepartmentDTO department = service.findDepartmentById(dno);
		if (department != null) {
			responseEntity = new ResponseEntity<>(department, HttpStatus.CREATED);
		} else {
			responseEntity = new ResponseEntity<>("FAILED : Department Not Found", HttpStatus.CREATED);
		}
		return responseEntity;
	}

	@GetMapping("/employees/departments")
	public ResponseEntity<?> findAllDepartments() {
		ResponseEntity<?> responseEntity = null;
		List<DepartmentDTO> departments = service.findAllDepartments();
		responseEntity = new ResponseEntity<>(departments, HttpStatus.CREATED);
		return responseEntity;
	}

	@GetMapping("/employees/{eid}/departments")
	public ResponseEntity<EmployeeDTO> FindEmployeeDetails(@PathVariable("eid") int eid) {
		ResponseEntity<EmployeeDTO> responseEntity = null;

		EmployeeDTO employeeDto = new EmployeeDTO();
		
		Employee employee = service.findEmployee(eid).get();
		
		DepartmentDTO department = service.findDepartmentById(employee.getDno());
		
		employeeDto.setEmployee(employee);
		employeeDto.setDepartment(department);
		
		if (employee != null) {
			responseEntity = new ResponseEntity<>(employeeDto, HttpStatus.CREATED);
		}
		return responseEntity;
	}
}
