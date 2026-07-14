package com.coforge.main;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.coforge.model.Employee;

public class HQLMainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		
		//each transaction needs one session
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		/*
		// HQL SELECT select *
		Query query = session.createQuery("from Employee"); // employee is model class
		List<Employee> list = query.list();
		System.out.println(list);
		
		// static select query
		Query query = session.createQuery("from Employee where eid = 101"); // employee is model class
		List<Employee> list = query.list();
		System.out.println(list);
		
		// HQL Dynamic select
		Query query = session.createQuery("from Employee where eid = :id");
		query.setParameter("id",101);
		List<Employee> list = query.list();
		System.out.println(list);
		
		// select only ename
		Query query = session.createQuery("select ename from Employee");
		List<String> list = query.list();
		System.out.println(list);
		
		//HQL Update
		Query query = session.createQuery("update Employee set ename = :name where eid = :id");
		query.setParameter("id",101);
		query.setParameter("name","Hola");
		int n = query.executeUpdate();
		if(n == 1) {
			System.out.println("Employee Object Updated");
		}
		else {
			System.out.println("Employee Object is not Updated");
		}
		*/
		
		// HQL Delete
		Query query = session.createQuery("delete from Employee where eid = :id");
		query.setParameter("id",5);
		int n = query.executeUpdate();
		if(n == 1) {
			System.out.println("Employee Object Deleted");
		}
		else {
			System.out.println("Employee Object is not Deleted");
		}
		
		transaction.commit();
		session.close();
		factory.close();
		
		System.out.println("Employee Object Saved");
	}

}
