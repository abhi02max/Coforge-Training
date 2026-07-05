package com.coforge.day4.exception;

public class ExceptionTest3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Before Exception");
		try {
			//int a = 10/0;
			//int b = Integer.parseInt("abc");
			int[] ar = new int[-5];
		}catch(ArithmeticException e) {
			System.out.println("Error : "+e.getMessage());
		}catch(NumberFormatException e) {
			System.out.println("Error : "+e.getMessage());
		}finally {
			System.out.println("Finally Block");
		}
		
		System.out.println("After Exception");
	}

}