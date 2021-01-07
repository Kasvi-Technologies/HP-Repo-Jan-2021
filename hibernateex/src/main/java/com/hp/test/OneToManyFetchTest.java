package com.hp.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.hp.mappings.Employee;
import com.hp.mappings.Product1;
import com.hp.mappings.ProductDetail;
import com.hp.mappings.Student;

public class OneToManyFetchTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
EntityManagerFactory  emf= Persistence.createEntityManagerFactory("HibernatePU");
		
		//obtain the connection from pool of connection objects
		//similar to Connection 
		EntityManager entityManager = emf.createEntityManager();

		Query q = entityManager.createQuery("select e from Student e");
		List<Student>  productLst = q.getResultList();

		productLst.stream().forEach(System.out::println);
		
		
		
	}

}
