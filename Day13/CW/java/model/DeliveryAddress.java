package com.coforge.model;

public class DeliveryAddress {
	private String city;
	private String state;

	public DeliveryAddress() {
		super();
	}

	public DeliveryAddress(String city, String state) {
		super();
		this.city = city;
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "DelivaryAddress [city=" + city + ", state=" + state + "]";
	}


}
