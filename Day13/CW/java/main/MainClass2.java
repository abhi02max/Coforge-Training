package com.coforge.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.coforge.model.Customer;

public class MainClass2 { // assume - this is main application it is depends on Employee
							// we will create employee (dependent object) in IOC container (Application
							// context)by xml based
	public static void main(String[] args) {

		// this application context is nothing but IOC container which is a type of
		// global memory where u can store all the common code (just like context in
		// react)
		// objects are stored here and get injected when we access or use it.
		// which enables loosely coupled classes (MainClass and Employee) and prevents
		// application crash which we encounter by tightly coupled classes where we
		// directly
		// create the object of another inside this class using new keyword!
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Customer customer = (Customer) context.getBean("customer1");
		System.out.println(customer);

	}
}
