package com.coforge.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.coforge.model.Employee;

public class MainClass { //assume - this is main application it is depends on Employee
	                     //we will create employee (dependent object) in IOC container (Application context)by xml based
	public static void main(String[] args) {
		
		//this application context is nothing but IOC container which is a type of
		//global memory where u can store all the common code (just like context in react)
		//objects are stored here and get injected when we access or use it.
		//which enables loosely coupled classes (MainClass and Employee) and prevents
		//application crash which we encounter by tightly coupled classes where we directly
		//create the object of another inside this class using new keyword!
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		Employee employee = (Employee) context.getBean("employee1");
		System.out.println(employee);
		
		Employee employee2 = (Employee) context.getBean("employee2");
		System.out.println(employee2);
		
	}
}
