package com.day11day12oops;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * Stock manager
 * Getting the stock information name of stock,no of shares to buy and price
 */
public class StockManager {
	
	/**
	 * ArrayList to maintain stocks data 
	 */
	List<StockPortfolio> stocks = new ArrayList<StockPortfolio>();    
	double total_value = 0;

	public void addStock() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter total number of stocks to buy : ");
		int s = sc.nextInt();
		double value = 0;
		/*
		 * Getting stock info from user and add number of stocks
		 */
		for (int i = 0; i < s; i++) {                                
			/*
			 * creating the object of StockPortfolio to set stock info
			 */
			StockPortfolio stock = new StockPortfolio();             
			/*
			 * Taking input for stock from user and  setting the value
			 */
			System.out.println("Please enter the name of the Stock: ");            
			stock.setStockName(sc.next());
			System.out.println("Please enter the total number of shares you want to buy : ");
			stock.setQuantity(sc.nextInt());
			System.out.println("Please enter the price per share: ");
			stock.setPerSharePrice(sc.nextDouble());

			/**
			 * calculating value of stock
			 */
			value = stock.getQuantity() * stock.getPerSharePrice();              
			stock.setTotalSharePrice(value);                                     
			/**
			 * calculating the total value of all stocks
			 */
			total_value += value;                                             
			/**
			 * adding the stock to array list
			 */
			stocks.add(stock);                                                
		}
		sc.close();
	}

	public void printStock() {                                           
		/**
		 *  printing the stocks report
		 */
		for (StockPortfolio stocks : stocks) {
			System.out.println(stocks);
		}
		System.out.println(" \n Total value of stock in your trading account is: " + total_value);      

	}
}