package com.day11day12oops;

import java.util.Scanner;

public class Account {

	static int amount = 0;
	
	Scanner sc = new Scanner(System.in);
	/*
	 * creating object of StockManager class
	 */
	StockManager sm = new StockManager();
	
	
	public static int getAmount() {
		return amount;
	}
	public static void setAmount(int amount) {
		Account.amount = amount;
	}
	
	/*
	 * method to credit amount into account
	 */
	public void credit() {
		System.out.println("Enter Ammout ot credit in account :");
		double creditValue = sc.nextDouble();
		
		amount += creditValue;
		System.out.println("Current Balance is :" +amount);
	}
	/*
	 *This Method to withdraw amount from account
	 */
	public void debit() {
		System.out.println("Enter Amount to debit from account  :");
		double debitValue = sc.nextDouble();
		if(amount - debitValue < 0) {
			System.out.println("Insufficint funds");
			return;
		}
		amount -=debitValue;
		System.out.println("Current Balance is :" +amount);
	}
	/*
	 * This method prints the total amount in account
	 */
	public void amountUpdate() {
		System.out.println("Total Balance is : "+amount);
	}
}
