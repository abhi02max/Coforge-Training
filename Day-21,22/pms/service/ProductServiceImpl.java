package com.coforge.pms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coforge.pms.dto.SupplierDTO;
import com.coforge.pms.exception.ProductNotFoundException;
import com.coforge.pms.model.Product;
import com.coforge.pms.repo.ProductRepo;
import com.coforge.pms.service.client.SupplierClient;

@Service
public class ProductServiceImpl implements ProductService{

	private ProductRepo repo;
	private Environment environment;
	private SupplierClient client ;
	
	public ProductServiceImpl(ProductRepo repo, Environment environment, SupplierClient client) {
		super();
		this.repo = repo;
		this.environment = environment;
		this.client = client;
	}
	
	@Override
	public boolean saveProduct(Product product) {
		repo.save(product);
		return true;
	}

	@Override
	public boolean updateProduct(int pid, Product product) {
		if(!repo.existsById(pid)) {
			throw new ProductNotFoundException(environment.getProperty("pms.invalid.product-notFound"));
		}
		repo.save(product);
		return true;
	}

	@Override
	public boolean deleteProduct(int pid) {
		if(!repo.existsById(pid)) {
			throw new ProductNotFoundException(environment.getProperty("pms.invalid.product-notFound"));
		}
		repo.deleteById(pid);
		return true;
	}

	@Override
	public Optional<Product> findById(int pid) {

		if(!repo.existsById(pid)) {
			throw new ProductNotFoundException(environment.getProperty("pms.invalid.product-notFound"));
		}
		Optional<Product> product = repo.findById(pid);
		return product;
	}

	@Override
	public List<Product> findAllProducts() {
		return (List<Product>)repo.findAll();
	}

	@Override
	public List<Product> findByPqnt(int pqnt) {
		List<Product> products = repo.findByPqnt(pqnt);
		return products;
	}

	@Override
	public List<Product> findByPprice(int pprice) {

		List<Product> products = repo.findByPprice(pprice);
		return products;
	}

	@Override
	public List<Product> findByPname(String pname) {
		List<Product> products = repo.findByPname(pname);
		return products;
	}

	@Override
	@Transactional
	public boolean deleteByPname(String pname) {
		int n = repo.deleteByPname(pname);
		if (n == 0) {
			throw new ProductNotFoundException(environment.getProperty("pms.invalid.employee-notFound"));
		}
		return true;
	}

	@Override
	public String getInfoList() {
		String info = repo.getInfo();
		return info;
	}

	
	
	@Override
	public SupplierDTO findSupplierById(long supid) {
		SupplierDTO supplier = client.getSupplierById(supid);
		return supplier;
	}

}
