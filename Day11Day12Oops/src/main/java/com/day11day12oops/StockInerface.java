package com.day11day12oops;

public interface StockInerface {

	double valueOf();
	void buy(int amount, String symbol);
	void sell(int amount, String symbol);
	void printReport();
}
