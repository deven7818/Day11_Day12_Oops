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
	
	Scanner sc = new Scanner(System.in);
	
	/*
	 * this method prints account balance 
	 */
	public double valueOf() {
		System.out.println("The cuurent Account Balance is : " +Account.getAmount());
		return Account.getAmount();
	}

	public StockPortfolio findStock(String name) {
		for(StockPortfolio temp : stocks) {
			/*
			 * checking user stock matches the list stock
			 */
			if(temp.getStockName().equals(name)) {
				return temp;
			}
		}
		return null;
	}
	
	/**
	 * Method to create stock
	 * @param name - name of the stock
	 * @return -stock
	 */
	public StockPortfolio createStock(String name) {
		
		System.out.println("Enter the price per Share :");
		double pricePerShare = sc.nextDouble();
		
		StockPortfolio stock = new StockPortfolio();
		stock.setStockName(name);
		stock.setQuantity(0);
		stock.setPerSharePrice(pricePerShare);
		stocks.add(stock);
		
		return stock;
	} 
	
	/**
	 * Method to buy Stocks
	 * @param amount - amount for buying shares
	 * @param symbol - symbol for share
	 */
	public void buy(int amount,String symbol) {
		if(amount > Account.getAmount()) {
			System.out.println("Insufficient fund");
			return;
		}
		
		StockPortfolio stock = findStock(symbol);
		/*
		 * if findStock is null then call createStockMethod
		 */
		if(stock == null) {
			stock = createStock(symbol);
		}
		
		int quantity = (int)(amount / stock.getPerSharePrice());
		double debitValue = quantity * stock.getPerSharePrice();
		Account.debit(debitValue);
		stock.setQuantity(quantity + stock.getQuantity());
		stock.setTotalSharePrice(stock.getQuantity() * stock.getPerSharePrice());
	}
	
	/**
	 * Method to sell the stocks 
	 * @param amount - amount to sell share
	 * @param symbol - symbol for shares
	 */
	
	public void sell(int amount, String symbol) {
		StockPortfolio stock = findStock(symbol);
		
		if(stock == null) {
			System.out.println("You cant buy this stock");
			return;
		}
		int quantity = (int)(amount / stock.getPerSharePrice());
		
		if(quantity > stock.getQuantity()) {
			quantity = stock.getQuantity();
		}
		
		stock.setQuantity(stock.getQuantity() - quantity);
		
		double stockValue = stock.getQuantity() * stock.getPerSharePrice();
		stock.setTotalSharePrice(stockValue);
		
		double creditValue = stock.getPerSharePrice() * quantity;
		Account.credit(creditValue);
	}
	

	/**
	 * printing the stocks report
	 */
	public void printStockReport() {
		List<StockPortfolio> temp = stocks;
		int value = 0;
		for (StockPortfolio stock : temp) {
			System.out.println(stock);
			value += stock.getTotalSharePrice();
		}
		System.out.println("Your Entire portfolio is worth : "+value);
	}
}