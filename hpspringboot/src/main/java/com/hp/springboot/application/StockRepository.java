package com.hp.springboot.application;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface StockRepository extends CrudRepository<Stock, Integer>{

	List<Stock> findByStockName(String stockName);
	//CRUDrepository will automatically create all methods for you
	//insert
	//updae
	//delete
	//findByStockId
	
}
