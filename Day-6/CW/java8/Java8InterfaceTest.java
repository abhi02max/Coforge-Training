package com.coforge.day6.java8;

interface Myinterface {
	public void myMethod();

	default void myMethod2() {
		System.out.println("hi");
	};

	static void myMethod3() {
		System.out.println("hi 1");
	}

	public class Java8InterfaceTest {
		
		public void myMethod() {
			System.out.println("hi 3");
		}
		
		public void myMethod2() {
			System.out.println("hi 4");
		}
		
		public void myMethod3() {
			System.out.println("hi 5");
		}
	}
}
