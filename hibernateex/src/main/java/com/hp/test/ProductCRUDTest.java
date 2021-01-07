package com.hp.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.hp.entities.Product;

public class ProductCRUDTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//DataSource
				EntityManagerFactory  emf= Persistence.createEntityManagerFactory("HibernatePU");
				
				//obtain the connection from pool of connection objects
				//similar to Connection 
				EntityManager entityManager = emf.createEntityManager();
				
				Product product = entityManager.getReference(Product.class, 2);
			
				
				entityManager.getTransaction().begin();
			
				//entityManager.remove(product);  removal
				entityManager.getTransaction().commit();
				
				System.out.println("Product record is deleted...............");
				
				
				Product product1 = entityManager.getReference(Product.class, 7);
				product1.setPrice(3000);
				entityManager.getTransaction().begin();
				
				entityManager.merge(product1); // updation
				entityManager.getTransaction().commit();
				
				
				Product p = entityManager.find(Product.class, 5);
				System.out.println(p);
				
				//JPQL -> Java persistence query language
				Query query = 
						entityManager.createQuery("select p from Product p where price > 5000");
				
				List<Product> productLst = query.getResultList();
				
				productLst.stream().forEach(System.out::println);
				
				Query query1 = 
						entityManager.createQuery("select p from Product p where p.name like '%o%' ");
				
				System.out.println("query based on product name");
				List<Product> productLst1 = query1.getResultList();
				productLst1.stream().forEach(System.out::println);
				
				
				Query query2 = 
						entityManager.createQuery("select p from Product p where id > :id");
				
				query2.setParameter("id", 5);
				
				System.out.println("query based on product id greater than 5");
				List<Product> productLst2 = query2.getResultList();
				productLst2.stream().forEach(System.out::println);
				
				
				query2 = 
						entityManager.createNamedQuery("find products based on id");
				
				query2.setParameter("id", 5);
				
				System.out.println("named query based on product id greater than 5");
				productLst2 = query2.getResultList();
				productLst2.stream().forEach(System.out::println);
				
				
				query2 = 
						entityManager.createQuery("select count(*) from Product");
				
				System.out.println(query2.getSingleResult());
				
				query2 = 
						entityManager.createQuery("select max(p.price) from Product p");
				
				System.out.println(query2.getSingleResult());
				
	}

}
