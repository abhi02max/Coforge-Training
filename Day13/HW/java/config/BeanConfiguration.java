package com.coforge.config;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.coforge.model.Address;
import com.coforge.model.Student;

@Configuration
public class BeanConfiguration {
	
	@Bean(name="student1")
	public Student getStudent1() {
		Student student = new Student();
		student.setStudentId(111);
		student.setStudentName("Kumar");
		student.setSubjects(Arrays.asList("DAA" , "DBMS"));
		student.setSkills(new HashSet<String>(Arrays.asList("React" , "Spring")));
		Map<String, Integer> marks = new HashMap<String, Integer>();
		marks.put("Java", 95);
		marks.put("Python", 90);
		marks.put("SQL", 88);
		student.setMarks(marks);
		student.setAddress(getAddress());
		return student;
		
	}
	
	@Bean(name="address")
	public Address getAddress() {
		Address address = new Address("Hyderabad", "Telangana");
		return address;
	}
}
