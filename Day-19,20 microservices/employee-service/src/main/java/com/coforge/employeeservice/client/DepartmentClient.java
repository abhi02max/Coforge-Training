package com.coforge.employeeservice.client;

import com.coforge.employeeservice.dto.DepartmentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "DEPARTMENT-SERVICE")
public interface DepartmentClient {

    @GetMapping("/departments/{id}")
    DepartmentDTO getDepartmentById(@PathVariable("id") Long id);
}
