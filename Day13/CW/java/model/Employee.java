package com.coforge.model;

public class Employee { // Model class , POJO class are same
	private int eid;
	private String ename;
	private int esalary;
	private int dno;
	private Address address;
	private Project project;

	public Employee() {
		super();

	}

	public Employee(int eid, String ename, int esalary, int dno, Address address, Project project) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.esalary = esalary;
		this.dno = dno;
		this.address = address;
		this.project = project;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", esalary=" + esalary + ", dno=" + dno + ", address="
				+ address + ", project=" + project + "]";
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}
	

}
