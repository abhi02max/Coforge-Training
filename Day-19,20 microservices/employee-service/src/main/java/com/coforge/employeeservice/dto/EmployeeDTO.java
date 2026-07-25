package com.coforge.employeeservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeDTO {

    private Long employeeId;

    @NotBlank(message = "Employee Name is required")
    private String employeeName;

    @NotNull(message = "Salary is required")
    @Positive(message = "Salary must be greater than 0")
    private Double employeeSalary;

    @NotBlank(message = "Email is required")
    @Email(message = "Email must be valid")
    private String employeeEmail;

    @NotNull(message = "DepartmentId is required")
    private Long departmentId;

    public EmployeeDTO() {
    }

    public EmployeeDTO(Long employeeId, String employeeName, Double employeeSalary, String employeeEmail, Long departmentId) {
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

    public static EmployeeDTOBuilder builder() {
        return new EmployeeDTOBuilder();
    }

    public static class EmployeeDTOBuilder {
        private Long employeeId;
        private String employeeName;
        private Double employeeSalary;
        private String employeeEmail;
        private Long departmentId;

        public EmployeeDTOBuilder employeeId(Long employeeId) {
            this.employeeId = employeeId;
            return this;
        }

        public EmployeeDTOBuilder employeeName(String employeeName) {
            this.employeeName = employeeName;
            return this;
        }

        public EmployeeDTOBuilder employeeSalary(Double employeeSalary) {
            this.employeeSalary = employeeSalary;
            return this;
        }

        public EmployeeDTOBuilder employeeEmail(String employeeEmail) {
            this.employeeEmail = employeeEmail;
            return this;
        }

        public EmployeeDTOBuilder departmentId(Long departmentId) {
            this.departmentId = departmentId;
            return this;
        }

        public EmployeeDTO build() {
            return new EmployeeDTO(employeeId, employeeName, employeeSalary, employeeEmail, departmentId);
        }
    }
}
