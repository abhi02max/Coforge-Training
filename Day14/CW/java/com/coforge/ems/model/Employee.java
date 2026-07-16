package com.coforge.ems.model;

public class Employee { // Model class , POJO class are same
	private int eid;
	private String ename;
	private int esalary;
	private int dno;

	public Employee() {
		super();
	}

	public Employee(int eid, String ename, int esalary, int dno) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.esalary = esalary;
		this.dno = dno;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", esalay=" + esalary + ", dno=" + dno + "]";
	}

	public int getEid() {
		return eid;
	}

	public String getEname() {
		return ename;
	}

	public int getEsalary() {
		return esalary;
	}

	public int getDno() {
		return dno;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public void setEsalary(int esalary) {
		this.esalary = esalary;
	}

	public void setDno(int dno) {
		this.dno = dno;
	}

}
