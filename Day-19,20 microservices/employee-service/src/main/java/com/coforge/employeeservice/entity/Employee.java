package com.coforge.employeeservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employees")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    @Column(nullable = false)
    private String employeeName;

    @Column(nullable = false)
    private Double employeeSalary;

    @Column(nullable = false, unique = true)
    private String employeeEmail;

    @Column(nullable = false)
    private Long departmentId;

    public Employee() {
    }

    public Employee(Long employeeId, String employeeName, Double employeeSalary, String employeeEmail, Long departmentId) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeSalary = employeeSalary;
        this.employeeEmail = employeeEmail;
        this.departmentId = departmentId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Double getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(Double employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public static EmployeeBuilder builder() {
        return new EmployeeBuilder();
    }

    public static class EmployeeBuilder {
        private Long employeeId;
        private String employeeName;
        private Double employeeSalary;
        private String employeeEmail;
        private Long departmentId;

        public EmployeeBuilder employeeId(Long employeeId) {
            this.employeeId = employeeId;
            return this;
        }

        public EmployeeBuilder employeeName(String employeeName) {
            this.employeeName = employeeName;
            return this;
        }

        public EmployeeBuilder employeeSalary(Double employeeSalary) {
            this.employeeSalary = employeeSalary;
            return this;
        }

        public EmployeeBuilder employeeEmail(String employeeEmail) {
            this.employeeEmail = employeeEmail;
            return this;
        }

        public EmployeeBuilder departmentId(Long departmentId) {
            this.departmentId = departmentId;
            return this;
        }

        public Employee build() {
            return new Employee(employeeId, employeeName, employeeSalary, employeeEmail, departmentId);
        }
    }
}
