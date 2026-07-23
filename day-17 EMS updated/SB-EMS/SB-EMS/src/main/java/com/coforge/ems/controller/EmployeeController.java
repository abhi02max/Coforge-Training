package com.coforge.ems.controller;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.coforge.ems.exception.InvalidEmployeeObjectException;
import com.coforge.ems.model.Employee;
import com.coforge.ems.service.EmployeeService;
import org.springframework.web.bind.annotation.PutMapping;
// import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;


@RestController //combination of @Controller and @ResponseBody, indicating that this class handles HTTP requests and returns JSON responses
@RequestMapping({"/", "/api/v1/ems"})
public class EmployeeController {

    private final EmployeeService service;
    // private Environment env;

    @Autowired // constructor injection for EmployeeService dependency
    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @PostMapping("/employees")
    public ResponseEntity<String> saveEmployee(@RequestBody Employee employee) { //receives a JSON representation of an Employee object in the request body and maps it to the Employee parameter
        

        try {
            Employee savedEmployee = service.addEmployee(employee);
            return ResponseEntity.ok("SUCCESS : Employee saved successfully! " + savedEmployee);
        } catch (InvalidEmployeeObjectException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("FAILED : DB Error : " + e.getMessage());
        }
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable Integer id, @RequestBody Employee employee) { // receives ID from the path and updated employee details from the request body
        
        try {
            Employee updatedEmployee = service.updateEmployee(id, employee);
            return ResponseEntity.ok("SUCCESS : Employee updated successfully! " + updatedEmployee);
        } catch (InvalidEmployeeObjectException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("FAILED : DB Error : " + e.getMessage());
        }
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Integer id) { // receives ID from the path
        
        try {
            String result = service.deleteEmployee(id);
            return ResponseEntity.ok("SUCCESS : " + result);
        } catch (InvalidEmployeeObjectException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("FAILED : DB Error : " + e.getMessage());
        }
    }

    @DeleteMapping("/employees/name/{name}")
    public ResponseEntity<String> deleteEmployeeByName(@PathVariable String name) {
        try {
            String result = service.deleteEmployeeByName(name);
            return ResponseEntity.ok("SUCCESS : " + result);
        } catch (InvalidEmployeeObjectException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("FAILED : DB Error : " + e.getMessage());
        }
    }

    @GetMapping("/employees/id/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable Integer id) {
        try {
            Employee employee = service.getEmployeeById(id);
            return ResponseEntity.ok(employee);
        } catch (InvalidEmployeeObjectException e) {
            return ResponseEntity.badRequest().body("ID not present: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("FAILED : DB Error : " + e.getMessage());
        }
    }

    @GetMapping("/employees/name/{name}")
    public ResponseEntity<?> getEmployeeByName(@PathVariable String name) {
        try {
            Employee employee = service.getEmployeeByName(name);
            return ResponseEntity.ok(employee);
        } catch (InvalidEmployeeObjectException e) {
            return ResponseEntity.badRequest().body("Name not present: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("FAILED : DB Error : " + e.getMessage());
        }
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> findAllEmp() {
        return ResponseEntity.ok(service.getAllEmployees());
    }

    @GetMapping("/employees/ids")
    public ResponseEntity<java.util.List<Integer>> getAllEmployeeIds() {
        return ResponseEntity.ok(service.getAllEmployeeIds());
    }

    @GetMapping("/employees/stats")
    public ResponseEntity<?> getSalaryStats() {
        return ResponseEntity.ok(service.getSalaryStats());
    }
}
