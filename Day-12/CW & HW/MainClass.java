package com.coforge.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.coforge.model.Employee;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		
		//each transaction needs one session
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Employee employee = new Employee(5,"priya",13000,10);
		// session.save(employee); //INSERT
		// session.update(employee); //UPDATE
		// there may be multiple sessions that's why we specify entity name
		//Employee emp = session.get(Employee.class, 101); //SELECT
		//System.out.print(emp);
		session.delete(employee); //DELETE
		
		transaction.commit();
		session.close();
		factory.close();
		
		System.out.println("Employee Object Saved");
	}

}
