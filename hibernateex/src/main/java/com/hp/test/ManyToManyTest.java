package com.hp.test;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.hp.mappings.Address;
import com.hp.mappings.Department;
import com.hp.mappings.Employee;
import com.hp.mappings.Person;
import com.hp.mappings.Product1;
import com.hp.mappings.ProductDetail;
import com.hp.mappings.Stock;
import com.hp.mappings.Student;

public class ManyToManyTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
EntityManagerFactory  emf= Persistence.createEntityManagerFactory("HibernatePU");
		
		//obtain the connection from pool of connection objects
		//similar to Connection 
		EntityManager entityManager = emf.createEntityManager();
		
		Stock stock1 = new Stock("Infy");
		Stock stock2 = new Stock("TCS");
		Stock stock3 = new Stock("Reliance");
		
		Set<Person> persons = new HashSet<Person>();
		Set<Stock> stocks = new HashSet<Stock>();
		
		Person person1 = new Person("A");
		Person person2 = new Person("B");
		
		persons.add(person1);
		persons.add(person2);
		
		stocks.add(stock1);
		stocks.add(stock2);
		stocks.add(stock3);
		
		
		entityManager.getTransaction().begin();
		
		person1.setStocks(stocks);
		person2.setStocks(stocks);
		
		stock1.setPersons(persons);
		stock2.setPersons(persons);
		stock3.setPersons(persons);
	
		entityManager.persist(stock1);
		entityManager.persist(stock2);
		entityManager.persist(stock3);
		
		entityManager.persist(person1);
		entityManager.persist(person2);
		
		entityManager.getTransaction().commit();

	}

}
