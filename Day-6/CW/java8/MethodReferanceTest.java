package com.coforge.day6.java8;


@FunctionalInterface
interface myInterface1 {
	void showMessage();
}
public class MethodReferanceTest {
	void Instance() {
		System.out.println("Instance is created");
	}
	
	static void Instance1() {
		System.out.println("Instance 1 is created");
	}
	MethodReferanceTest() {
		System.out.println("Constructor");
	}
	
	public static void main(String args[]) {
		MethodReferanceTest obj = new MethodReferanceTest();
		myInterface1 reference = obj::Instance;
		reference.showMessage();
		
	}
}