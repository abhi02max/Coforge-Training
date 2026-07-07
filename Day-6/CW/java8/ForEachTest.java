package com.coforge.day6.java8;

import java.util.Arrays;
import java.util.List;

public class ForEachTest {
	public static void main(String[] args) {
	List<Integer> list = Arrays.asList(10, 20, 30, 40);
	
		list.forEach(n -> System.out.println(n));
		
		list.forEach(n->{
			if(n % 2 == 0) 
				System.out.println(n);
			});
		System.out.println("------------");
		
		list.forEach(System.out::println);
		}
	}


