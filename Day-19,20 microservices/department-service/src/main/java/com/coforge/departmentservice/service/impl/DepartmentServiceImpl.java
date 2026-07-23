package com.coforge.departmentservice.service.impl;

import com.coforge.departmentservice.dto.DepartmentDTO;
import com.coforge.departmentservice.entity.Department;
import com.coforge.departmentservice.exception.DepartmentNotFoundException;
import com.coforge.departmentservice.repository.DepartmentRepository;
import com.coforge.departmentservice.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public DepartmentDTO saveDepartment(DepartmentDTO departmentDTO) {
        Department department = mapToEntity(departmentDTO);
        Department savedDepartment = departmentRepository.save(department);
        return mapToDTO(savedDepartment);
    }

    @Override
    public List<DepartmentDTO> getAllDepartments() {
        List<Department> departments = departmentRepository.findAll();
        return departments.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public DepartmentDTO getDepartmentById(Long departmentId) {
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new DepartmentNotFoundException("Department not found with id: " + departmentId));
        return mapToDTO(department);
    }

    @Override
    public DepartmentDTO updateDepartment(Long departmentId, DepartmentDTO departmentDTO) {
        Department existingDepartment = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new DepartmentNotFoundException("Department not found with id: " + departmentId));

        existingDepartment.setDepartmentName(departmentDTO.getDepartmentName());
        existingDepartment.setDepartmentCode(departmentDTO.getDepartmentCode());
        existingDepartment.setDepartmentLocation(departmentDTO.getDepartmentLocation());

        Department updatedDepartment = departmentRepository.save(existingDepartment);
        return mapToDTO(updatedDepartment);
    }

    @Override
    public void deleteDepartment(Long departmentId) {
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new DepartmentNotFoundException("Department not found with id: " + departmentId));
        departmentRepository.delete(department);
    }

    private DepartmentDTO mapToDTO(Department department) {
        return DepartmentDTO.builder()
                .departmentId(department.getDepartmentId())
                .departmentName(department.getDepartmentName())
                .departmentCode(department.getDepartmentCode())
                .departmentLocation(department.getDepartmentLocation())
                .build();
    }

    private Department mapToEntity(DepartmentDTO departmentDTO) {
        return Department.builder()
                .departmentId(departmentDTO.getDepartmentId())
                .departmentName(departmentDTO.getDepartmentName())
                .departmentCode(departmentDTO.getDepartmentCode())
                .departmentLocation(departmentDTO.getDepartmentLocation())
                .build();
    }
}
