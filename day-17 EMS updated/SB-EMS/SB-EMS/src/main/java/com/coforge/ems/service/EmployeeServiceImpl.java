package com.coforge.ems.service;

import com.coforge.ems.exception.InvalidEmployeeObjectException;
import com.coforge.ems.model.Employee;
import com.coforge.ems.repo.EmployeeRepo;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Service implementation for managing Employee business logic.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepo employeeRepo;

    /**
     * Constructor injection for EmployeeRepo.
     * No field injection is used.
     *
     * @param employeeRepo the employee repository
     */
    public EmployeeServiceImpl(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public Employee addEmployee(Employee employee) {
        if (employee == null) {
            throw new InvalidEmployeeObjectException("Employee object cannot be null");
        }
        return employeeRepo.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        // Sort employee list by empId (ascending) before returning
        return employeeRepo.findAll(Sort.by(Sort.Direction.ASC, "empId"));
    }

    @Override
    public java.util.List<Integer> getAllEmployeeIds() {
        return employeeRepo.findAllEmpIds();
    }

    @Override
    public com.coforge.ems.repo.SalaryStats getSalaryStats() {
        return employeeRepo.fetchSalaryStats();
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        if (id == null) {
            throw new InvalidEmployeeObjectException("Invalid employee ID provided");
        }
        return employeeRepo.findById(id)
                .orElseThrow(() -> new InvalidEmployeeObjectException("Employee not found with ID: " + id));
    }

    @Override
    public Employee getEmployeeByName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new InvalidEmployeeObjectException("Employee name cannot be empty for search");
        }
        return employeeRepo.findByEmpName(name)
                .orElseThrow(() -> new InvalidEmployeeObjectException("Employee not found with name: " + name));
    }

    @Override
    public Employee updateEmployee(Integer id, Employee employee) {
        if (id == null) {
            throw new InvalidEmployeeObjectException("Invalid employee ID for update");
        }
        if (employee == null) {
            throw new InvalidEmployeeObjectException("Employee details cannot be null for update");
        }

        // Check if ID mismatch occurs (protecting ID modification)
        if (employee.getEmpId() != null && !employee.getEmpId().equals(id)) {
            throw new InvalidEmployeeObjectException("Employee ID cannot be modified");
        }

        // Verify employee exists before updating
        Employee existingEmployee = employeeRepo.findById(id)
                .orElseThrow(() -> new InvalidEmployeeObjectException("Employee not found with ID: " + id));

        // Update fields
        existingEmployee.setEmpName(employee.getEmpName());
        existingEmployee.setEmpSalary(employee.getEmpSalary());
        existingEmployee.setEmpDepartment(employee.getEmpDepartment());
        existingEmployee.setEmpEmail(employee.getEmpEmail());

        return employeeRepo.save(existingEmployee);
    }

    @Override
    public String deleteEmployee(Integer id) {
        if (id == null) {
            throw new InvalidEmployeeObjectException("Invalid employee ID for delete");
        }

        // Verify employee exists before deleting
        Employee existingEmployee = employeeRepo.findById(id)
                .orElseThrow(() -> new InvalidEmployeeObjectException("Employee not found with ID: " + id));

        employeeRepo.delete(existingEmployee);
        return "Employee with ID " + id + " deleted successfully";
    }

    @Override
    @Transactional
    public String deleteEmployeeByName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new InvalidEmployeeObjectException("Employee name cannot be empty for delete");
        }

        List<Employee> toDelete = employeeRepo.findAllByEmpName(name);
        if (toDelete == null || toDelete.isEmpty()) {
            throw new InvalidEmployeeObjectException("Employee not found with name: " + name);
        }

        int count = toDelete.size();
        employeeRepo.deleteAll(toDelete);
        return "Deleted " + count + " employee(s) with name " + name;
    }

    @Override
    public List<Employee> getEmployeesByDepartment(String department) {
        if (department == null || department.trim().isEmpty()) {
            throw new InvalidEmployeeObjectException("Department cannot be empty");
        }
        return employeeRepo.findByEmpDepartment(department);
    }

    @Override
    public List<Employee> getEmployeesBySalaryRange(Double minSalary, Double maxSalary) {
        if (minSalary == null || maxSalary == null || minSalary > maxSalary) {
            throw new InvalidEmployeeObjectException("Invalid salary range boundaries");
        }
        return employeeRepo.findByEmpSalaryBetween(minSalary, maxSalary);
    }

    @Override
    public Long getEmployeeCount() {
        return employeeRepo.count();
    }
}
