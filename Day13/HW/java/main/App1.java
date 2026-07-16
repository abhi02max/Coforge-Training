package com.coforge.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.coforge.model.Student;

public class App1 {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
	
		Student student = (Student) context.getBean("student1");
		
		System.out.println(student);
	
	}

}
