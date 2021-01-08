package com.hp.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hp.dao.ProductDAO;
import com.hp.entity.Product;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductDAO productDAO;
	
	public ProductDAO getProductDAO() {
		return productDAO;
	}

	public void setProductDAO(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}

	@Transactional
	@Override
	public void insertProduct(Product product) {
		// TODO Auto-generated method stub
		
		productDAO.insertProduct(product);
		
		//
		
		//
	}

	@Transactional(readOnly = true)
	@Override
	public List<Product> fetchProducts() {
		// TODO Auto-generated method stub
		return productDAO.fetchProducts();
	}
	
	
	@Transactional(readOnly = true)
	@Override
	public Product fetchProductById(int productId) {
		// TODO Auto-generated method stub
		return productDAO.fetchProductById(productId);
	}

}
