package com.coforge.pms.dto;


public class SupplierDTO {
	
	
	private long supid;
	
	
	private String supname;
	
	
	private String city;

	public SupplierDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SupplierDTO(long supid, String supname, String city) {
		super();
		this.supid = supid;
		this.supname = supname;
		this.city = city;
	}

	public long getSupid() {
		return supid;
	}

	public void setSupid(long supid) {
		this.supid = supid;
	}

	public String getSupname() {
		return supname;
	}

	public void setSupname(String supname) {
		this.supname = supname;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "SupplierDTO [supid=" + supid + ", supname=" + supname + ", city=" + city + "]";
	}
	
	

	
}
