package com.hp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.hp.entity.Product;
import com.hp.entity.Stock;

@Repository(value = "sdaoImpl")
public class StockDAOImpl implements StockDAO{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Stock insertStock(Stock stock) {
		// TODO Auto-generated method stub
		entityManager.persist(stock);
		
		return stock;
	}

	@Override
	public List<Stock> fetchStocks() {
		// TODO Auto-generated method stub
		return entityManager.createQuery("select s from Stock s").getResultList();
	}

	@Override
	public Stock fetchStockById(int stockId) {
		// TODO Auto-generated method stub
		return (Stock) entityManager.createQuery("select s from Stock s where s.stockId = " + stockId)
				.getSingleResult();
	}

	@Override
	public void deleteStock(int stockId) {
		// TODO Auto-generated method stub
		
		Stock stock = entityManager.getReference(Stock.class, stockId);
		entityManager.remove(stock);
		
	}

	@Override
	public void updateStock(Stock stock) {
		// TODO Auto-generated method stub
		entityManager.merge(stock);
	}

	
	
}
