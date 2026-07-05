package com.coforge.day4.abstraction;

public class Rectangle extends Figure {
	public Rectangle() {
		super(20,30);
	}
	
	@Override
	public void area() {
		// TODO Auto-generated method stub
		int l = getLength();
		int b = getBreadth();
		System.out.println("Area of Rectangle : " + l * b);
	}
}