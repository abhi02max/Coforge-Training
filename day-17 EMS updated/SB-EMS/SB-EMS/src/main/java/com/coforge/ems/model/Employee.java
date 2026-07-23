package com.coforge.ems.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

/**
 * Entity class representing an Employee in the system.
 */
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "empId")
    private Integer empId;

    @Column(name = "empName")
    @NotBlank(message = "Employee Name cannot be empty")
    private String empName;

    @Column(name = "empSalary")
    @Positive(message = "Salary must be greater than zero")
    private Double empSalary;

    @Column(name = "empDepartment")
    @NotBlank(message = "Department is mandatory")
    private String empDepartment;

    @Column(name = "empEmail")
    @Email(message = "Invalid email")
    private String empEmail;

    /**
     * Default constructor.
     */
    public Employee() {
    }

    /**
     * Parameterized constructor (without ID, useful for creation).
     *
     * @param empName       the employee name
     * @param empSalary     the employee salary
     * @param empDepartment the employee department
     * @param empEmail      the employee email
     */
    public Employee(String empName, Double empSalary, String empDepartment, String empEmail) {
        this.empName = empName;
        this.empSalary = empSalary;
        this.empDepartment = empDepartment;
        this.empEmail = empEmail;
    }

    /**
     * Parameterized constructor (with ID, useful for updates and testing).
     *
     * @param empId         the employee ID
     * @param empName       the employee name
     * @param empSalary     the employee salary
     * @param empDepartment the employee department
     * @param empEmail      the employee email
     */
    public Employee(Integer empId, String empName, Double empSalary, String empDepartment, String empEmail) {
        this.empId = empId;
        this.empName = empName;
        this.empSalary = empSalary;
        this.empDepartment = empDepartment;
        this.empEmail = empEmail;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Double getEmpSalary() {
        return empSalary;
    }

    public void setEmpSalary(Double empSalary) {
        this.empSalary = empSalary;
    }

    public String getEmpDepartment() {
        return empDepartment;
    }

    public void setEmpDepartment(String empDepartment) {
        this.empDepartment = empDepartment;
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", empSalary=" + empSalary +
                ", empDepartment='" + empDepartment + '\'' +
                ", empEmail='" + empEmail + '\'' +
                '}';
    }
}