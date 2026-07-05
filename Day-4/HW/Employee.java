package com.coforge.assignment;

public class Employee {
	int id;
    String name;
    double monthlySalary;

    public Employee(int id, String name, double monthlySalary) {
        this.id = id;
        this.name = name;
        this.monthlySalary = monthlySalary;
    }

    double calculateAnnualSalary() {
        return monthlySalary * 12;
    }

    void displayInfo() {
        System.out.println("Employee ID : " + id);
        System.out.println("Employee Name : " + name);
        System.out.println("Monthly Salary : " + monthlySalary);
        System.out.println("Annual Salary : " + calculateAnnualSalary());
    }
}