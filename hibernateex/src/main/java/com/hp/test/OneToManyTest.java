package com.hp.test;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.hp.mappings.Address;
import com.hp.mappings.Department;
import com.hp.mappings.Employee;
import com.hp.mappings.Product1;
import com.hp.mappings.ProductDetail;
import com.hp.mappings.Student;

public class OneToManyTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
EntityManagerFactory  emf= Persistence.createEntityManagerFactory("HibernatePU");
		
		//obtain the connection from pool of connection objects
		//similar to Connection 
		EntityManager entityManager = emf.createEntityManager();

		Address schlooladdress = new Address("school" , "address", "Bangalore");
		Address homeaddress = new Address("home" , "address", "Bangalore");
		Address permanentaddress = new Address("permanent" , "address", "Bangalore");
		
		entityManager.getTransaction().begin();
		entityManager.persist(schlooladdress);
		entityManager.persist(homeaddress);
		entityManager.persist(permanentaddress);
		
		Student student = new Student("B");
		
		Set<Address> addressSet = new HashSet<Address>();
		addressSet.add(schlooladdress);
		addressSet.add(homeaddress);
		addressSet.add(permanentaddress);
		
		student.setAddresses(addressSet);
		
		
		//one to many 
		
		entityManager.persist(student);
		
		entityManager.getTransaction().commit();

	}

}
