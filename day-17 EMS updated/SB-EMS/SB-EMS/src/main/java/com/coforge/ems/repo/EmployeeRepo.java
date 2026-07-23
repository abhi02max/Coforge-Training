package com.coforge.ems.repo;

import com.coforge.ems.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository interface for Employee entity operations.
 */
@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

    /**
     * Finds an employee by their name.
     *
     * @param empName the employee name to search
     * @return an Optional containing the found Employee, or empty if not found
     */
    Optional<Employee> findByEmpName(String empName);

    /**
     * Finds all employees with the given name.
     *
     * @param empName the employee name to search
     * @return list of employees with the specified name
     */
    List<Employee> findAllByEmpName(String empName);

    /**
     * Custom query that returns only employee IDs for all records.
     * Useful for lightweight ID-only listings.
     *
     * @return list of employee IDs
     */
    @Query("SELECT e.empId FROM Employee e")
    List<Integer> findAllEmpIds();

    /**
     * Aggregated salary statistics: count, sum, max, min.
     *
     * @return a projection containing salary stats
     */
    @Query("SELECT COUNT(e) as count, SUM(e.empSalary) as sum, MAX(e.empSalary) as max, MIN(e.empSalary) as min FROM Employee e")
    SalaryStats fetchSalaryStats();

    /**
     * Finds employees belonging to a specific department.
     *
     * @param empDepartment the department to search
     * @return list of employees in the department
     */
    List<Employee> findByEmpDepartment(String empDepartment);

    /**
     * Finds employees with salaries within a specific range (inclusive).
     *
     * @param minSalary the minimum salary boundary
     * @param maxSalary the maximum salary boundary
     * @return list of employees within the salary range
     */
    List<Employee> findByEmpSalaryBetween(Double minSalary, Double maxSalary);

    /**
     * Counts the total number of employees.
     * Overrides the default count method.
     *
     * @return total count of employees
     */
    @Override
    long count();
}
