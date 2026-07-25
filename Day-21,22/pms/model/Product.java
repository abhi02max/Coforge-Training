package com.coforge.pms.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name="tbl_product")
public class Product {

	@Id
	@Column(name="pid",length=5)
	@NotNull
	private int pid;
	
	@Column(name="pname",length=20)
	@NotBlank
	private String pname;
	
	@Column(name="pprice",length=5)
	@Positive
	private int pprice;
	
	@Column(name="pqnt",length=5)
	@Positive
	private int pqnt;
	
	@Column(name="supid",length=5)
	private long supid;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(@NotNull int pid, @NotBlank String pname, @Positive int pprice, @Positive int pqnt, long supid) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.pprice = pprice;
		this.pqnt = pqnt;
		this.supid = supid;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getPprice() {
		return pprice;
	}

	public void setPprice(int pprice) {
		this.pprice = pprice;
	}

	public int getPqnt() {
		return pqnt;
	}

	public void setPqnt(int pqnt) {
		this.pqnt = pqnt;
	}

	public long getSupid() {
		return supid;
	}

	public void setSupid(long supid) {
		this.supid = supid;
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", pprice=" + pprice + ", pqnt=" + pqnt + ", supid=" + supid
				+ "]";
	}

	
	
}
