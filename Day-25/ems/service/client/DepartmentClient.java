package com.coforge.ems.service.client;

import java.util.List;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.coforge.ems.dto.DepartmentDTO;

@FeignClient(name="SB-DMS-SERVICE/api/v1/dms")
public interface DepartmentClient {
	@GetMapping("/departments/{dno}")
	public DepartmentDTO getDepartmentById(@PathVariable int dno);
	
	@GetMapping("/departments")
	public List<DepartmentDTO> getDepartments();
}
