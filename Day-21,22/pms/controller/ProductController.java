package com.coforge.pms.controller;

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

import com.coforge.pms.dto.ProductDTO;
import com.coforge.pms.dto.SupplierDTO;
import com.coforge.pms.model.Product;
import com.coforge.pms.service.ProductService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@RestController
@RequestMapping("api/v1/pms")
public class ProductController {

	private ProductService service;
	private Environment environment;
	
	
	@Autowired
	public ProductController(ProductService service, Environment environment) {
		super();
		this.service = service;
		this.environment = environment;
	}
	
	@PostMapping("/products")
	public ResponseEntity<String> saveProduct(@NotNull @Valid @RequestBody(required = false) Product product){
		ResponseEntity<String> responseEntity = null;
		
		boolean status = service.saveProduct(product);
		if(status) {
			responseEntity = new ResponseEntity<>(environment.getProperty("pms.save.success"),HttpStatus.CREATED);
		}
		return responseEntity;
	}
	
	@PutMapping("/products/{pid}")
	public ResponseEntity<String> updateProduct(@PathVariable int pid, @Valid @NotNull @RequestBody Product product){
		
		ResponseEntity<String> responseEntity = null;
		
		boolean status = service.updateProduct(pid,product);
		if(status) {
			responseEntity = new ResponseEntity<>(environment.getProperty("pms.update.success"),HttpStatus.CREATED);
		}
		return responseEntity;
	}
	
	@DeleteMapping("/products/{pid}")
	public ResponseEntity<String> deleteProduct(@PathVariable("pid") int pid){
		
		ResponseEntity<String> responseEntity = null;
		
		boolean status = service.deleteProduct(pid);
		if(status) {
			responseEntity = new ResponseEntity<>(environment.getProperty("pms.delete.success"),HttpStatus.CREATED);
		}
		return responseEntity;
		
	}
	
	@GetMapping("/products/{pid}")
	public ResponseEntity<?> findById(@PathVariable("pid") int pid){
		
		ResponseEntity<?> responseEntity = null;
		
		Optional<Product> product = service.findById(pid);
		if(product!=null) {
			responseEntity = new ResponseEntity<>(product.get(),HttpStatus.CREATED);
		}
		return responseEntity;
	}
	
	@GetMapping("/products")
	public ResponseEntity<?> findAllProducts(){
		
		ResponseEntity<?> responseEntity = null;
		List<Product> products = service.findAllProducts();
		responseEntity = new ResponseEntity<>(products,HttpStatus.CREATED);
		return responseEntity;
	}
	
	@GetMapping("/products/pqnt/{pqnt}")
	public ResponseEntity<?> findByPqnt(@PathVariable("pqnt") int pqnt){
		
		ResponseEntity<?> responseEntity = null;
		List<Product> products = service.findByPqnt(pqnt);
		responseEntity = new ResponseEntity<>(products,HttpStatus.CREATED);
		return responseEntity;
	}
	
	@GetMapping("/products/price/{pprice}")
	public ResponseEntity<?> findByPprice(@PathVariable("pprice") int pprice){
		
		ResponseEntity<?> responseEntity = null;
		List<Product> products = service.findByPprice(pprice);
		responseEntity = new ResponseEntity<>(products,HttpStatus.CREATED);
		return responseEntity;
	}
	
	@GetMapping("/products/pname/{pname}")
	public ResponseEntity<?> findByPname(@PathVariable("pname") String pname){
		ResponseEntity<?> responseEntity = null;
		List<Product> products = service.findByPname(pname);
		responseEntity = new ResponseEntity<>(products,HttpStatus.CREATED);
		return responseEntity;
	}
	
	@DeleteMapping("/products/pname/{pname}")
	public ResponseEntity<String> DeleteByPname(@PathVariable("pname") String pname) {
		ResponseEntity<String> responseEntity = null;

		boolean status = service.deleteByPname(pname);
		if (status) {
			responseEntity = new ResponseEntity<>(environment.getProperty("pms.delete.success"), HttpStatus.CREATED);
		}
		return responseEntity;
	}
	
	
	@GetMapping("/products/info")
	public ResponseEntity<?> getInfoList(){
		
		ResponseEntity<?> responseEntity = null;
		
		String info = service.getInfoList();
		responseEntity = new ResponseEntity<>(info,HttpStatus.CREATED);
		return responseEntity;
	}
	
	// Rest end points for feign client department
	@GetMapping("/products/suppliers/{supid}")
	public ResponseEntity<?> findSupplierById(@PathVariable long supid) {
		ResponseEntity<?> responseEntity = null;
		SupplierDTO supplier = service.findSupplierById(supid);
		if (supplier != null) {
			responseEntity = new ResponseEntity<>(supplier, HttpStatus.CREATED);
		} else {
			responseEntity = new ResponseEntity<>("FAILED : Supplier Not Found", HttpStatus.CREATED);
		}
		return responseEntity;
	}
	
	@GetMapping("/products/{pid}/suppliers")
	public ResponseEntity<ProductDTO> findProductDetails(@PathVariable int pid) {
		ResponseEntity<ProductDTO> responseEntity = null;
		ProductDTO productDto = new ProductDTO();
		
		Product product = service.findById(pid).get();
		SupplierDTO supplier = service.findSupplierById(product.getSupid());
		
		productDto.setProduct(product);
		productDto.setSupplier(supplier);
		
		if (product != null) {
			responseEntity = new ResponseEntity<>(productDto, HttpStatus.CREATED);
		}
		return responseEntity;
	}
	
	
}
