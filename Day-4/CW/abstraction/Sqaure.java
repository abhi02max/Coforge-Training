package com.coforge.day4.abstraction;

public class Sqaure extends Figure {
	public Sqaure() {
		super(10);
	}
	@Override
	public void area() {
		int side = getSide();
		System.out.println("Area of Square : " + side * side);
		
	}
}