package com.hp.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hp.config.AppConfig;
import com.hp.entity.Product;
import com.hp.service.ProductService;

public class SpringHbJPATest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AnnotationConfigApplicationContext context = 
							new AnnotationConfigApplicationContext(AppConfig.class);
		
		ProductService service = (ProductService) context.getBean("productServiceImpl");
		
		Product p = new Product("laptop", 10000, 8);
		Product p1 = new Product("mobile", 20000, 10);
		Product p2 = new Product("vehicle", 50000, 3);
		
		service.insertProduct(p);
		service.insertProduct(p1);
		service.insertProduct(p2);
		
	}

}
