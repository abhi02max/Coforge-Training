package com.coforge.assignment;

public class BankApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankAccount account = new BankAccount("SBI1001", 10000);

        account.checkBalance();

        account.deposit(5000);

        account.withdraw(3000);

        account.checkBalance();
	}

}