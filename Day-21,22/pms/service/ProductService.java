package com.coforge.pms.service;

import java.util.List;
import java.util.Optional;

import com.coforge.pms.dto.SupplierDTO;
import com.coforge.pms.model.Product;

public interface ProductService {

	public boolean saveProduct(Product product);
	
	public boolean updateProduct(int pid,Product product);
	
	public boolean deleteProduct(int pid);
		
	public List<Product> findAllProducts();
	
	public List<Product> findByPqnt(int pqnt);
	
	public List<Product> findByPprice(int pprice);
	
	public List<Product> findByPname(String pname);

	public boolean deleteByPname(String pname);

	public String getInfoList();

	public SupplierDTO findSupplierById(long supid);

	public Optional<Product> findById(int pid);

	

}
