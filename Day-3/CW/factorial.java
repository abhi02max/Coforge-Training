package com.coforge.day3;

import java.util.Scanner;

public class FactorialApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a limit:");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            long fact = 1;
            for (int j = 1; j <= i; j++) {
                fact *= j;
            }
            System.out.println("Factorial of " + i + " is: " + fact);
        }

        sc.close();
    }
}
