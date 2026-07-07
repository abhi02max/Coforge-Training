package com.coforge.ems.ui;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import  com.coforge.ems.controller.EmployeeController;
import  com.coforge.ems.model.Employee;
import com.mysql.cj.protocol.Resultset;

public class EmployeeApp {
	private static EmployeeController controller = new EmployeeController();
	public static void main(String[] args) throws SQLException {
		
		Scanner sc = new Scanner(System.in);
		String confirmation = "";
		do {		
			System.out.println("1.Create\n2.Update\n3.Delete\n4.Find\n5.FindAll\n6.Quit");
			System.out.println("Enter The Choice");
			int choice = sc.nextInt();
			switch(choice) {
			case 1:
				System.out.println("Enter employee id ,name,salary and department no");
				Employee employee = new Employee(sc.nextInt(),sc.next(),sc.nextInt(),sc.nextInt());
				System.out.println(controller.createEmployee(employee));
				break;	
			case 2:
				System.out.println("Enter Employ id That needs to be updated");
				int empid = sc.nextInt();
				System.out.println("Choose what you want to update/t1.Salary\n2.Department");
				int choice1 = sc.nextInt();
				if(choice1 == 1) {
					System.out.println("Enter Salary to be updated");
					int salary = sc.nextInt();
					controller.updateSalary(empid,salary);
					System.out.println(controller.updateSalary(empid,salary));
				}else {
					System.out.println("Enter Department Number to be updated");
					int deptno = sc.nextInt();
					controller.updateSalary(empid,deptno);
					System.out.println(controller.updateDepartmentNumber(empid,deptno));
				}
				break;
			case 3:
				System.out.println("Enter employee id to be Deleted");	
				int empid1 = sc.nextInt();
				System.out.println(controller.delete(empid1));	
				break;	
			case 4:
				System.out.println("Enter the Id of the Employee that Needs To be Searched");
				String result = controller.findEmployee(sc.nextInt());
				System.out.print(result);
				break;
			case 5:
				String result1 = controller.displayAll();
				    System.out.println(result1);
				break;
			case 6:
				System.exit(0);
			}
			System.out.println("Do You Want to Continue Yes/No");
			confirmation = sc.next();
		}while(confirmation.equalsIgnoreCase("Yes"));
	}

}
