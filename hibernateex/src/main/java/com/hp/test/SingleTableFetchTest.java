package com.hp.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.hp.entities.BankAccount;

public class SingleTableFetchTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

EntityManagerFactory  emf= Persistence.createEntityManagerFactory("HibernatePU");
		
		//obtain the connection from pool of connection objects
		//similar to Connection 
		EntityManager entityManager = emf.createEntityManager();
		
		Query query = entityManager.createQuery("select ba from BankAccount ba");
		List<BankAccount> bankAccounts = query.getResultList();
		bankAccounts.stream().forEach(System.out::println);
		
	}
}
