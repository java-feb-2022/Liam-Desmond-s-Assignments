package com.liam.bankaccount;

public class BankAccount {

	private double checking;
	private double savings;
	private static int accounts = 0;
	private static double totalAmount;
	


	public BankAccount() {
		this.checking = 100;
		this.savings = 100;
		totalAmount = 200;
		accounts++;
	}

	public double getChecking() {
		return checking;
	}

	public double getSavings() {
		return savings;
	}

	
	public static int howMany() {
		return accounts;
	}
	
	public static double moneyStored() {
		return totalAmount;
	}
	
	public void deposit(double amount, String account) {
		totalAmount += amount;
		if(account == "savings") {
			this.savings += amount;
		}
		else {
			this.checking += amount;
		}

	}
	
	public void widthdraw(double amount, String account) {

		if(account =="savings" ) {
			if(this.savings - amount >= 0) {
				this.savings -= amount;
				totalAmount -= amount;
			}
			else {
				System.out.println("Insufficient funds");
			}
		}
		else if(account == "checking") {
			if(this.checking - amount >= 0) {
				this.checking -= amount;
				totalAmount -= amount;
			}
			else {
				System.out.println("Insufficient funds");
			}
		}

			}
		
	
	

	
	public void seeTotal() {
		System.out.println(this.checking + this.savings);
	}

}
