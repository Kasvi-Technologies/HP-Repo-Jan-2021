package com.hp.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hp.config.AppConfig;
import com.hp.entity.Product;
import com.hp.service.ProductService;

public class SpringHbJPAFetchTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AnnotationConfigApplicationContext context = 
							new AnnotationConfigApplicationContext(AppConfig.class);
		
		ProductService service = (ProductService) context.getBean("productServiceImpl");
		
		System.out.println("Fetching all products..");
		service.fetchProducts().stream().forEach(System.out::println);
		
		
		System.out.println("Fetching  products based on id 2..");
		System.out.println(service.fetchProductById(2));
		
	}

}
