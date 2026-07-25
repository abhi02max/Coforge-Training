package com.coforge.employeeservice.service.impl;

import com.coforge.employeeservice.client.DepartmentClient;
import com.coforge.employeeservice.dto.DepartmentDTO;
import com.coforge.employeeservice.dto.EmployeeDTO;
import com.coforge.employeeservice.dto.EmployeeResponse;
import com.coforge.employeeservice.entity.Employee;
import com.coforge.employeeservice.exception.ResourceNotFoundException;
import com.coforge.employeeservice.repository.EmployeeRepository;
import com.coforge.employeeservice.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentClient departmentClient;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, DepartmentClient departmentClient) {
        this.employeeRepository = employeeRepository;
        this.departmentClient = departmentClient;
    }

    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
        Employee employee = mapToEntity(employeeDTO);
        Employee savedEmployee = employeeRepository.save(employee);
        return mapToDTO(savedEmployee);
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + employeeId));
        return mapToDTO(employee);
    }

    @Override
    public EmployeeDTO updateEmployee(Long employeeId, EmployeeDTO employeeDTO) {
        Employee existingEmployee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + employeeId));

        existingEmployee.setEmployeeName(employeeDTO.getEmployeeName());
        existingEmployee.setEmployeeSalary(employeeDTO.getEmployeeSalary());
        existingEmployee.setEmployeeEmail(employeeDTO.getEmployeeEmail());
        existingEmployee.setDepartmentId(employeeDTO.getDepartmentId());

        Employee updatedEmployee = employeeRepository.save(existingEmployee);
        return mapToDTO(updatedEmployee);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + employeeId));
        employeeRepository.delete(employee);
    }

    @Override
    public EmployeeResponse getEmployeeWithDepartment(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + employeeId));

        DepartmentDTO departmentDTO = departmentClient.getDepartmentById(employee.getDepartmentId());

        return EmployeeResponse.builder()
                .employeeId(employee.getEmployeeId())
                .employeeName(employee.getEmployeeName())
                .employeeSalary(employee.getEmployeeSalary())
                .employeeEmail(employee.getEmployeeEmail())
                .department(departmentDTO)
                .build();
    }

    private EmployeeDTO mapToDTO(Employee employee) {
        return EmployeeDTO.builder()
                .employeeId(employee.getEmployeeId())
                .employeeName(employee.getEmployeeName())
                .employeeSalary(employee.getEmployeeSalary())
                .employeeEmail(employee.getEmployeeEmail())
                .departmentId(employee.getDepartmentId())
                .build();
    }

    private Employee mapToEntity(EmployeeDTO employeeDTO) {
        return Employee.builder()
                .employeeId(employeeDTO.getEmployeeId())
                .employeeName(employeeDTO.getEmployeeName())
                .employeeSalary(employeeDTO.getEmployeeSalary())
                .employeeEmail(employeeDTO.getEmployeeEmail())
                .departmentId(employeeDTO.getDepartmentId())
                .build();
    }
}
