package com.coforge.model;

import java.util.List;

public class Customer {
	private int customerId;
	private String customerName;
	private List<String> emails;
	private List<DeliveryAddress> delivaryAddress;

	public Customer() {
		super();
	}

	public Customer(int customerId, String customerName, List<String> emails, List<DeliveryAddress> delivaryAddress) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.emails = emails;
		this.delivaryAddress = delivaryAddress;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", emails=" + emails
				+ ", delivaryAddress=" + delivaryAddress + "]";
	}

	public int getCustomerId() {
		return customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public List<String> getEmails() {
		return emails;
	}

	public List<DeliveryAddress> getDelivaryAddress() {
		return delivaryAddress;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public void setEmails(List<String> emails) {
		this.emails = emails;
	}

	public void setDelivaryAddress(List<DeliveryAddress> delivaryAddress) {
		this.delivaryAddress = delivaryAddress;
	}

}
