package com.hp.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hp.config.AppConfig;
import com.hp.entity.Product;
import com.hp.entity.Stock;
import com.hp.service.ProductService;
import com.hp.service.StockService;

public class StockSpringHbJPATest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AnnotationConfigApplicationContext context = 
							new AnnotationConfigApplicationContext(AppConfig.class);
		
		StockService stockServiceImpl = (StockService) context.getBean("stockServiceImpl");
		
		Stock s = new Stock("tcs", 3000, 2);
		
		Stock s1 = new Stock("infy", 1200, 1);
		Stock s2 = new Stock("reliance", 2000, 3);
		stockServiceImpl.insertStock(s);
		stockServiceImpl.insertStock(s1);
		stockServiceImpl.insertStock(s2);
		context.close();
	}

}
