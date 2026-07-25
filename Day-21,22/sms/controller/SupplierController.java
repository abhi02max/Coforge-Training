package com.coforge.sms.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coforge.sms.model.Supplier;
import com.coforge.sms.service.SupplierService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@RestController
@RequestMapping("/api/v1/sms")
public class SupplierController {

	private SupplierService service;
	private Environment environment;
	
	
	@Autowired
	public SupplierController(SupplierService service, Environment environment) {
		super();
		this.service = service;
		this.environment = environment;
	}
	
	@PostMapping("/suppliers")
	public ResponseEntity<String> saveSupplier(@NotNull @Valid @RequestBody(required = false) Supplier supplier){
		ResponseEntity<String> responseEntity = null;
		
		boolean status = service.saveProduct(supplier);
		if(status) {
			responseEntity = new ResponseEntity<>(environment.getProperty("sms.save.success"),HttpStatus.CREATED);
		}
		return responseEntity;
	}
	
	@PutMapping("/suppliers/{supid}")
	public ResponseEntity<String> updateSupplier(@PathVariable long supid, @Valid @NotNull @RequestBody Supplier supplier){
		
		ResponseEntity<String> responseEntity = null;
		
		boolean status = service.updateProduct(supid,supplier);
		if(status) {
			responseEntity = new ResponseEntity<>(environment.getProperty("sms.update.success"),HttpStatus.CREATED);
		}
		return responseEntity;
	}
	
	@DeleteMapping("/suppliers/{supid}")
	public ResponseEntity<String> deleteSupplier(@PathVariable("supid") long supid){
		
		ResponseEntity<String> responseEntity = null;
		
		boolean status = service.deleteSupplier(supid);
		if(status) {
			responseEntity = new ResponseEntity<>(environment.getProperty("sms.delete.success"),HttpStatus.CREATED);
		}
		return responseEntity;
		
	}
	
	@GetMapping("/suppliers/{supid}")
	public ResponseEntity<?> findById(@PathVariable("supid") long supid){
		
		ResponseEntity<?> responseEntity = null;
		
		Optional<Supplier> supplier = service.findById(supid);
		if(supplier!=null) {
			responseEntity = new ResponseEntity<>(supplier.get(),HttpStatus.CREATED);
		}
		return responseEntity;
	}
	
	@GetMapping("/suppliers")
	public ResponseEntity<?> findAllSuppliers(){
		
		ResponseEntity<?> responseEntity = null;
		List<Supplier> suppliers = service.findAllSuppliers();
		responseEntity = new ResponseEntity<>(suppliers,HttpStatus.CREATED);
		return responseEntity;
	}
}
