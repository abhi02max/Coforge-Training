package com.coforge.day6.java8;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;

public class DateTest {
	public static void main(String[] args) {
		Date date = new Date(0);
		System.out.println(date);
		
		LocalDate dat = LocalDate.now();
		System.out.println(dat);
		
		LocalTime localtime =  LocalTime.now();
		System.out.println(localtime);
	}
}
