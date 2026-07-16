package com.coforge.model;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Student {
	private int studentId;
	private String studentName;
	private List<String> subjects;
	private Set<String> skills;
	private Map<String, Integer> marks;

	public Student() {
		super();
	}

	public Student(int studentId, String studentName, List<String> subjects, Set<String> skills,
			Map<String, Integer> marks, Address address) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.subjects = subjects;
		this.skills = skills;
		this.marks = marks;
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", subjects=" + subjects
				+ ", skills=" + skills + ", marks=" + marks + ", address=" + address + "]";
	}

	public int getStudentId() {
		return studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public List<String> getSubjects() {
		return subjects;
	}

	public Set<String> getSkills() {
		return skills;
	}

	public Map<String, Integer> getMarks() {
		return marks;
	}

	public Address getAddress() {
		return address;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public void setSubjects(List<String> subjects) {
		this.subjects = subjects;
	}

	public void setSkills(Set<String> skills) {
		this.skills = skills;
	}

	public void setMarks(Map<String, Integer> marks) {
		this.marks = marks;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	private Address address;

}
