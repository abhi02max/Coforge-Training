package com.coforge.day4.abstraction;

public class VehicleApp {

	public static void main(String[] args) {
		/*
		Bike b = new Bike();
		b.noOfWheels();
		b.brandName();
		b.noOfEngine();
		
		Scooty s = new Scooty();
		s.brandName();
		s.noOfEngine();
		s.noOfWheels();
		*/
		
		VechiclePlan vechicle;
		vechicle = new Bike();
		vechicle.numberOfEngine();
		vechicle.numberOfWheel();
		vechicle.brandName();

	}

}