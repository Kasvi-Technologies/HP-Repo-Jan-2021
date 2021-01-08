package com.hp.dao;

import java.util.List;

import com.hp.entity.Product;

public interface ProductDAO {

	public void insertProduct(Product product);
	public List<Product> fetchProducts();
	public Product fetchProductById(int productId);
	
}
