package com.coforge.employeeservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeResponse {

    private Long employeeId;
    private String employeeName;
    private Double employeeSalary;
    private String employeeEmail;
    private DepartmentDTO department;

    public EmployeeResponse() {
    }

    public EmployeeResponse(Long employeeId, String employeeName, Double employeeSalary, String employeeEmail, DepartmentDTO department) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeSalary = employeeSalary;
        this.employeeEmail = employeeEmail;
        this.department = department;
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

    public DepartmentDTO getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentDTO department) {
        this.department = department;
    }

    public static EmployeeResponseBuilder builder() {
        return new EmployeeResponseBuilder();
    }

    public static class EmployeeResponseBuilder {
        private Long employeeId;
        private String employeeName;
        private Double employeeSalary;
        private String employeeEmail;
        private DepartmentDTO department;

        public EmployeeResponseBuilder employeeId(Long employeeId) {
            this.employeeId = employeeId;
            return this;
        }

        public EmployeeResponseBuilder employeeName(String employeeName) {
            this.employeeName = employeeName;
            return this;
        }

        public EmployeeResponseBuilder employeeSalary(Double employeeSalary) {
            this.employeeSalary = employeeSalary;
            return this;
        }

        public EmployeeResponseBuilder employeeEmail(String employeeEmail) {
            this.employeeEmail = employeeEmail;
            return this;
        }

        public EmployeeResponseBuilder department(DepartmentDTO department) {
            this.department = department;
            return this;
        }

        public EmployeeResponse build() {
            return new EmployeeResponse(employeeId, employeeName, employeeSalary, employeeEmail, department);
        }
    }
}
