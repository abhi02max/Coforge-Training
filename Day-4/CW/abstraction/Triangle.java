package com.coforge.day4.abstraction;

public class Triangle extends Figure {
	public Triangle() {
		super(1011L,15000L);
	}
	
	@Override
	public void area() {
		// TODO Auto-generated method stub
		long h = getHeight();
		long b = getBase();
		System.out.println("Area of Triangle : " + (h * b)/2);
	}
}