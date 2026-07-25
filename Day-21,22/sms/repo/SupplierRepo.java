package com.coforge.sms.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.coforge.sms.model.Supplier;

@Repository
public interface SupplierRepo extends CrudRepository<Supplier, Long> {

}
