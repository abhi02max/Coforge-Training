package com.coforge.assignment;

import java.util.ArrayList;

public class Cart {
	ArrayList<Product> products = new ArrayList<>();

    public void addProduct(Product p) {
        products.add(p);
        System.out.println(p.name + " Added.");
    }

    public void removeProduct(int id) {

        for (Product p : products) {

            if (p.id == id) {
                products.remove(p);
                System.out.println("Product Removed.");
                return;
            }
        }

        System.out.println("Product Not Found.");
    }

    public void calculateBill() {

        double total = 0;

        System.out.println("\nProducts:");

        for (Product p : products) {
            System.out.println(p.name + " - ₹" + p.price);
            total += p.price;
        }

        System.out.println("--------------------");
        System.out.println("Total Bill = ₹" + total);
    }
}