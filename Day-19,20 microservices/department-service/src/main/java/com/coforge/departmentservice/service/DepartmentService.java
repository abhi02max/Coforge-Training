package com.coforge.departmentservice.service;

import com.coforge.departmentservice.dto.DepartmentDTO;

import java.util.List;

public interface DepartmentService {

    DepartmentDTO saveDepartment(DepartmentDTO departmentDTO);

    List<DepartmentDTO> getAllDepartments();

    DepartmentDTO getDepartmentById(Long departmentId);

    DepartmentDTO updateDepartment(Long departmentId, DepartmentDTO departmentDTO);

    void deleteDepartment(Long departmentId);
}
