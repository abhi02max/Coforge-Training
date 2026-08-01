package com.coforge.ems.dto;


//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;

public class DepartmentDTO {

	
	private int dno;

	
	private String dname;

	public DepartmentDTO(int dno, String dname) {
		super();
		this.dno = dno;
		this.dname = dname;
	}

	public DepartmentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getDno() {
		return dno;
	}

	public void setDno(int dno) {
		this.dno = dno;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	@Override
	public String toString() {
		return "Department [dno=" + dno + ", dname=" + dname + "]";
	}

}
