package com.coforge.sms.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="tbl_supplier")
public class Supplier {
	
	@Id
	@Column(name="supid",length=5)
	@NotNull
	private long supid;
	
	@Column(name="supname",length=20)
	@NotBlank
	private String supname;
	
	@Column(name="city",length=20)
	@NotBlank
	private String city;

	public Supplier() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Supplier(@NotNull long supid, @NotBlank String supname, @NotBlank String city) {
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
		return "Supplier [supid=" + supid + ", supname=" + supname + ", city=" + city + "]";
	}
	
	
	
}
