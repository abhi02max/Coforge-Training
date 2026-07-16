package com.coforge.model;

public class Project {

	private int pid;
	private String pname;

	public Project() {
		super();
	}

	public Project(int pid, String pname) {
		super();
		this.pid = pid;
		this.pname = pname;
	}

	@Override
	public String toString() {
		return "Project [pid=" + pid + ", pname=" + pname + "]";
	}

	public int getPid() {
		return pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

}
