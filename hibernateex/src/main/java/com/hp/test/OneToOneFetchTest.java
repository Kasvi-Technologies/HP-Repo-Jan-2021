package com.hp.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.hp.mappings.Product1;
import com.hp.mappings.ProductDetail;

public class OneToOneFetchTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
EntityManagerFactory  emf= Persistence.createEntityManagerFactory("HibernatePU");
		
		//obtain the connection from pool of connection objects
		//similar to Connection 
		EntityManager entityManager = emf.createEntityManager();

		Query q = entityManager.createQuery("select p1 from Product1 p1");
		List<Product1>  productLst = q.getResultList();

		productLst.stream().forEach(System.out::println);
		
		System.out.println("stock > 50");
		 q = entityManager.createQuery("select p1 from Product1 p1 where p1.productDetail.stock >50");
		 productLst = q.getResultList();

			productLst.stream().forEach(System.out::println);
		
	}

}
