package com.hp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hp.dao.ProductDAO;
import com.hp.dao.StockDAO;
import com.hp.entity.Stock;

@Service
public class StockServiceImpl implements StockService{

	//private StockDAO stockDAO = new StockDAOImpl();
	
	@Autowired
	@Qualifier(value = "sdaoImpl")
	private StockDAO stockDAO;
	
	@Transactional
	@Override
	public Stock insertStock(Stock stock) {
		// TODO Auto-generated method stub
		return stockDAO.insertStock(stock);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Stock> fetchStocks() {
		// TODO Auto-generated method stub
		return stockDAO.fetchStocks();
	}

	@Transactional(readOnly = true)
	@Override
	public Stock fetchStockById(int stockId) {
		// TODO Auto-generated method stub
		return stockDAO.fetchStockById(stockId);
	}

	@Transactional
	@Override
	public void deleteStock(int stockId) {
		// TODO Auto-generated method stub
		stockDAO.deleteStock(stockId);
	}

	@Transactional
	@Override
	public void updateStock(Stock stock) {
		// TODO Auto-generated method stub
		stockDAO.updateStock(stock);
	}

	
	
}
