package com.hp.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.hp.mappings.Department;
import com.hp.mappings.Employee;
import com.hp.mappings.Product1;
import com.hp.mappings.ProductDetail;

public class ManyToOneTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
EntityManagerFactory  emf= Persistence.createEntityManagerFactory("HibernatePU");
		
		//obtain the connection from pool of connection objects
		//similar to Connection 
		EntityManager entityManager = emf.createEntityManager();

		Department d = new Department("HR");
		
		
		entityManager.getTransaction().begin();
		entityManager.persist(d);
		
		
		Employee e = new Employee("A");
		e.setDepartment(d);
		
		Employee e1 = new Employee("B");
		e1.setDepartment(d);
		
		
		Employee e2 = new Employee("C");
		e2.setDepartment(d);
		
		
		
		entityManager.persist(e);
		
		entityManager.persist(e1);
		entityManager.persist(e2);
		//entityManager.persist(e3);
		entityManager.getTransaction().commit();

	}

}
