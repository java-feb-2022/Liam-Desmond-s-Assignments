package com.liam.bankaccount;

public class BankTest {

	public static void main(String[] args) {
		
		BankAccount a = new BankAccount();
		BankAccount b = new BankAccount();
		BankAccount c = new BankAccount();
		
		a.deposit(50.00, "checking");
		b.deposit(250.00, "savings");
		c.deposit(75.25, "checking");
		
		a.widthdraw(300.00, "checking");
		
		a.seeTotal();
		
		a.widthdraw(25.00, "checking");
		double x = a.getChecking();
		System.out.println(x);
		
		b.widthdraw(20.00, "savings");
		b.seeTotal();
		double y = b.getSavings();
		System.out.println(y);
		
		c.widthdraw(100.00, "savings");
		c.seeTotal();
		
		System.out.println(BankAccount.moneyStored());
		System.out.println(BankAccount.howMany());

	}

}
