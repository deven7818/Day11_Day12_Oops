package com.day11day12oops;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Stock manager Getting the stock information name of stock,no of shares to buy
 * and price
 */
public class StockManager {

	/**
	 * ArrayList to maintain stocks data
	 */
	List<StockPortfolio> stocks = new ArrayList<StockPortfolio>();
	double totalValue = 0;

	StockPortfolio port = new StockPortfolio();

	public void addStock() {
		if (StockPortfolio.getTotalValue() < Account.getAmount() || Account.getAmount() > 1) {

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
				 * Taking input for stock from user and setting the value
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
				/*
				 * checking if stock value is less than account balance
				 */
				if (value < Account.getAmount()) {
					/*
					 * setting total share price as value
					 */
					stock.setTotalSharePrice(value);
					/*
					 * debit amount by stock value
					 */
					Account.amount -= value;
					stocks.add(stock); //added stock to list
					/**
					 * calculating the total value of all stocks
					 */
					totalValue += value;
					StockPortfolio.setTotalValue(totalValue);
				} else {
					//print insufficient balance to add stock
					System.out.println("Sorry .. Insufficient balance in account to buy stocks");
					break;
				}

			}
		sc.close();
		} else {
			System.out.println("Unable to add shares due to insufficent balance in account");
			;
		}
	}

	/**
	 * printing the stocks report
	 */
	public void printStock() {
		
		for (StockPortfolio stocks : stocks) {
			System.out.println(stocks);
		}
		System.out.println(" \n Total value of stock in your trading account is: " + totalValue);

	}
}