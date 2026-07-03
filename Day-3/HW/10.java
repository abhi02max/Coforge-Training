package com.coforge.day3;

import java.util.Scanner;

public class CalculatorApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String confirmation = "";

        do {
            System.out.println("Enter Your Numbers:");
            int a = sc.nextInt();
            int b = sc.nextInt();

            System.out.println("1.Add  2.Sub  3.Mul  4.Div  5.Exit");
            System.out.println("Enter the Choice: ");
            int choice = sc.nextInt();

            int res; 

            switch (choice) {
                case 1:
                    res = a + b;
                    System.out.println("Addition: " + res);
                    break;
                case 2:
                    res = a - b;
                    System.out.println("Subtraction: " + res);
                    break;
                case 3:
                    res = a * b;
                    System.out.println("Multiplication: " + res);
                    break;
                case 4:
                    if (b != 0) {
                        res = a / b;
                        System.out.println("Division: " + res);
                    } else {
                        System.out.println("Error: Division by zero!");
                    }
                    break;
                case 5:
                    System.exit(0);
            }

            System.out.println("Want to continue [Yes | No]?");
            confirmation = sc.next();

        } while (confirmation.equalsIgnoreCase("Yes"));

        sc.close();
    }
}
