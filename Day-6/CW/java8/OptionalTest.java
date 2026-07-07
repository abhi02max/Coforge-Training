package com.coforge.day6.java8;

import java.util.Optional;

class Employee {
	private int ename;

	public int getEname() {
		return ename;
	}

	public void setEname(int ename) {
		this.ename = ename;
	}

	public class OptionalTest {
		public static Optional<Employee> getEmployee() {
			Employee employee = null;
			Optional<Employee> optionalEmployee = Optional.ofNullable(employee);
			return optionalEmployee;
		}

		public static void main(String args[]) {
			Optional<Employee> optionalEmployee = getEmployee();

			if (optionalEmployee.isPresent()) {
				Employee employee = optionalEmployee.get();
				System.out.println(employee.getEname());
			} else {
				System.out.println("Employee not found");
			}

		}

	}

}