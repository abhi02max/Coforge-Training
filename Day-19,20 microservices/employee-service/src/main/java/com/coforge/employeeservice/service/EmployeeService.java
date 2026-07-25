package com.coforge.employeeservice.service;

import com.coforge.employeeservice.dto.EmployeeDTO;
import com.coforge.employeeservice.dto.EmployeeResponse;

import java.util.List;

public interface EmployeeService {

    EmployeeDTO saveEmployee(EmployeeDTO employeeDTO);

    List<EmployeeDTO> getAllEmployees();

    EmployeeDTO getEmployeeById(Long employeeId);

    EmployeeDTO updateEmployee(Long employeeId, EmployeeDTO employeeDTO);

    void deleteEmployee(Long employeeId);

    EmployeeResponse getEmployeeWithDepartment(Long employeeId);
}
