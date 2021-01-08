package com.hp.dao;

import java.util.List;

import com.hp.entity.Stock;

public interface StockDAO {

	public Stock insertStock(Stock stock);
	public List<Stock> fetchStocks();
	public Stock fetchStockById(int stockId);
	
	public void deleteStock(int stockId);
	
	public void updateStock(Stock stock);
	
}
