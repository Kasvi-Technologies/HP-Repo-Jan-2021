package com.hp.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.hp.mappings.Product1;
import com.hp.mappings.ProductDetail;

public class OneToOneTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
EntityManagerFactory  emf= Persistence.createEntityManagerFactory("HibernatePU");
		
		//obtain the connection from pool of connection objects
		//similar to Connection 
		EntityManager entityManager = emf.createEntityManager();

		ProductDetail pd = new ProductDetail(10, "C", "Flipkart");
		
		
		entityManager.getTransaction().begin();
		entityManager.persist(pd);
		
		
		Product1 p = new Product1("Laptop", 5000);
		p.setProductDetail(pd);
		entityManager.persist(p);
		
		entityManager.getTransaction().commit();

	}

}
