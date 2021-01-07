package com.hp.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.hp.entities.Product;

public class ProductTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Collection of database connection objects
		//DataSource
		EntityManagerFactory  emf= Persistence.createEntityManagerFactory("HibernatePU");
		
		//obtain the connection from pool of connection objects
		//similar to Connection 
		EntityManager entityManager = emf.createEntityManager();
		
		Product product = new Product ("Vehicle", 1000);
		
		entityManager.getTransaction().begin();
		entityManager.persist(product);  // insert query
		entityManager.getTransaction().commit();
		
		System.out.println("Product record is inserted...............");
		
	}

}
