package com.coforge.sms.exception;

public class SupplierNotFoundException extends RuntimeException{

	public SupplierNotFoundException(String errorMessage) {
		super(errorMessage);
	}
}
