package com.coforge.ems.service;

import com.coforge.ems.model.Employee;
import java.util.List;
import com.coforge.ems.repo.SalaryStats;

/**
 * Service interface defining business logic operations for Employee management.
 */
public interface EmployeeService {

    /**
     * Adds a new employee to the system.
     *
     * @param employee the employee details to add
     * @return the saved employee entity
     */
    Employee addEmployee(Employee employee);

    /**
     * Retrieves all employees in the system, sorted by empId.
     *
     * @return sorted list of all employees
     */
    List<Employee> getAllEmployees();

    /**
     * Retrieves only the employee IDs for all records using a custom query.
     *
     * @return list of employee IDs
     */
    java.util.List<Integer> getAllEmployeeIds();

    /**
     * Returns salary aggregation statistics (count, sum, max, min).
     *
     * @return salary stats projection
     */
    SalaryStats getSalaryStats();

    /**
     * Searches for an employee by their ID.
     *
     * @param id the employee ID
     * @return the found employee
     */
    Employee getEmployeeById(Integer id);

    /**
     * Searches for an employee by their name.
     *
     * @param name the employee name
     * @return the found employee
     */
    Employee getEmployeeByName(String name);

    /**
     * Updates an existing employee's details.
     *
     * @param id       the ID of the employee to update
     * @param employee the new employee details
     * @return the updated employee entity
     */
    Employee updateEmployee(Integer id, Employee employee);

    /**
     * Deletes an employee from the system by their ID.
     *
     * @param id the employee ID to delete
     * @return a success message
     */
    String deleteEmployee(Integer id);

    /**
     * Deletes an employee from the system by their name.
     *
     * @param name the employee name to delete
     * @return a success message
     */
    String deleteEmployeeByName(String name);

    /**
     * Retrieves all employees belonging to a specific department.
     *
     * @param department the department name
     * @return list of employees in the department
     */
    List<Employee> getEmployeesByDepartment(String department);

    /**
     * Retrieves all employees whose salary falls within the specified range (inclusive).
     *
     * @param minSalary the minimum salary
     * @param maxSalary the maximum salary
     * @return list of employees in the salary range
     */
    List<Employee> getEmployeesBySalaryRange(Double minSalary, Double maxSalary);

    /**
     * Counts the total number of employees in the database.
     *
     * @return the total employee count
     */
    Long getEmployeeCount();
}