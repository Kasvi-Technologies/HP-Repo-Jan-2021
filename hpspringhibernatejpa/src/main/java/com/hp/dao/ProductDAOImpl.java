package com.hp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.hp.entity.Product;

@Repository
public class ProductDAOImpl implements ProductDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertProduct(Product product) {
		// TODO Auto-generated method stub
		entityManager.persist(product);
	}

	@Override
	public List<Product> fetchProducts() {
		// TODO Auto-generated method stub
		return entityManager.createQuery("select p from Product p").getResultList();
		
	}

	@Override
	public Product fetchProductById(int productId) {
		// TODO Auto-generated method stub
		return (Product) entityManager.createQuery("select p from Product p where p.productId = " + productId)
					.getSingleResult();
	}

}
