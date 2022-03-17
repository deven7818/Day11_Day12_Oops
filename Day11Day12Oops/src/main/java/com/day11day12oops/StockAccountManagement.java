package com.day11day12oops;
import java.util.Scanner;

/**
 *Adding the stock by using addStock method 
 *Printing Stocks by printStock method
 *
 */
public class StockAccountManagement {
	
	//main function
	public static void main(String[] args) {
		System.out.println("Welcome to stock account management");
		Scanner sc = new Scanner(System.in);
		/**
		 * creating object of StockManager
		 */
		StockManager sm = new StockManager();                                                     
		/**
		 * will iterate till we close the scanner
		 */
		while (true) {                                                                              
			System.out.println(" \n Please enter your choice : "
								+ "\n1.Add Stock" 
								+ "\n2.print stock report"
								+ "\n3.Exit program");

			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				/*
				 * calling add stock method
				 */
				sm.addStock();
				break;

			case 2:
				/**
				 *  calling the print method
				 */
				sm.printStock();
				break;

			case 3:
				System.out.println("Exited from stock account management program");
				sc.close();   
				return;

			default:
				System.out.println("Enter valid choice between 1 to 3");
			}

		}

	}
}