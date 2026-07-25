package com.coforge.sms.service;

import java.util.List;
import java.util.Optional;

import com.coforge.sms.model.Supplier;

public interface SupplierService {

	public boolean saveProduct(Supplier supplier);

	public boolean updateProduct(long supid, Supplier supplier);

	public boolean deleteSupplier(long supid);

	public Optional<Supplier> findById(long supid);

	public List<Supplier> findAllSuppliers();

}
