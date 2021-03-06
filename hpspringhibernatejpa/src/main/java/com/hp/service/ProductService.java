package com.hp.service;

import java.util.List;

import com.hp.entity.Product;

public interface ProductService {

	public void insertProduct(Product product);
	public List<Product> fetchProducts();
	public Product fetchProductById(int productId);
	
}
