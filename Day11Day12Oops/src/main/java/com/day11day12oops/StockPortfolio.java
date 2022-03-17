package com.day11day12oops;

/**
 * StockPortfolio class holding the list of stocks ,read from the input file 
 *
 */
public class StockPortfolio {

	/**
	 * variable declaration
	 */
	private String stockName;
	private int quantity;
	private double perSharePrice;
	private double totalSharePrice;

	/**
	 * getters and setters
	 */
	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPerSharePrice() {
		return perSharePrice;
	}

	public void setPerSharePrice(double perSharePrice) {
		this.perSharePrice = perSharePrice;
	}

	public double getTotalSharePrice() {
		return totalSharePrice;
	}

	public void setTotalSharePrice(double totalSharePrice) {
		this.totalSharePrice = totalSharePrice;
	}
	
	/*
	 * 
	 * toString method
	 */
	@Override
	public String toString() {
		System.out.println(" Share Report for " + stockName.toUpperCase());
		System.out.println(" Share Name: " + stockName.toUpperCase());
		System.out.println(" Total quantity of share purchased: " + quantity);
		System.out.println(" Price per share is : " + perSharePrice);
		System.out.println(" Total value of this share is: " + totalSharePrice);
		return "";
	}
}