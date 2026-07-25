package com.coforge.sms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.coforge.sms.exception.SupplierNotFoundException;
import com.coforge.sms.model.Supplier;
import com.coforge.sms.repo.SupplierRepo;

@Service
public class SupplierServiceImpl implements SupplierService {

	private SupplierRepo repo;
	private Environment environment;

	public SupplierServiceImpl(SupplierRepo repo, Environment environment) {
		super();
		this.repo = repo;
		this.environment = environment;
	}

	@Override
	public boolean saveProduct(Supplier supplier) {
		repo.save(supplier);
		return true;
	}

	@Override
	public boolean updateProduct(long supid, Supplier supplier) {
		if (!repo.existsById(supid)) {
			throw new SupplierNotFoundException(environment.getProperty("sms.invalid.supplier-notFound"));
		}
		repo.save(supplier);
		return true;
	}

	@Override
	public boolean deleteSupplier(long supid) {
		if (!repo.existsById(supid)) {
			throw new SupplierNotFoundException(environment.getProperty("sms.invalid.supplier-notFound"));
		}
		repo.deleteById(supid);
		return true;
	}

	@Override
	public Optional<Supplier> findById(long supid) {
		if (!repo.existsById(supid)) {
			throw new SupplierNotFoundException(environment.getProperty("sms.invalid.supplier-notFound"));
		}
		Optional<Supplier> supplier = repo.findById(supid);
		return supplier;
	}

	@Override
	public List<Supplier> findAllSuppliers() {
		return (List<Supplier>) repo.findAll();
	}

}
