package com.coforge.assignment;

public class ShoppingApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Customer customer = new Customer(101, "Abhiram");

        Product p1 = new Product(1, "Laptop", 55000);
        Product p2 = new Product(2, "Mouse", 700);
        Product p3 = new Product(3, "Keyboard", 1200);

        customer.cart.addProduct(p1);
        customer.cart.addProduct(p2);
        customer.cart.addProduct(p3);

        customer.cart.removeProduct(2);

        customer.cart.calculateBill();
	}

}