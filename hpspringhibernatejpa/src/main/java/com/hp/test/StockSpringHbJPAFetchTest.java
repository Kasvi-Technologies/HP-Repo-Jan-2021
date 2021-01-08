package com.hp.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hp.config.AppConfig;
import com.hp.entity.Product;
import com.hp.entity.Stock;
import com.hp.service.ProductService;
import com.hp.service.StockService;

public class StockSpringHbJPAFetchTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AnnotationConfigApplicationContext context = 
							new AnnotationConfigApplicationContext(AppConfig.class);
		
		StockService stockServiceImpl = (StockService) context.getBean("stockServiceImpl");
		stockServiceImpl.fetchStocks().stream().forEach(System.out::println);
		
		Stock s = stockServiceImpl.fetchStockById(5);
		
		s.setQuantity(10);
		
		stockServiceImpl.updateStock(s);
		
		stockServiceImpl.deleteStock(6);
		
		
		
		context.close();
	}

}
