package com.coforge.day4.abstraction;

public abstract class Vehicle implements VechiclePlan {

    @Override
    public void numberOfEngine() {
        System.out.println("I have 1 Engine");
    }
}