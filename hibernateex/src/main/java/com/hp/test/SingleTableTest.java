package com.hp.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.hp.entities.Account;
import com.hp.entities.BankAccount;
import com.hp.entities.CreditCard;
import com.hp.entities.Product;

public class SingleTableTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManagerFactory  emf= Persistence.createEntityManagerFactory("HibernatePU");
		
		//obtain the connection from pool of connection objects
		//similar to Connection 
		EntityManager entityManager = emf.createEntityManager();
		
		Account account = new Account(1, "sample");
		
		BankAccount bankAccount = new BankAccount(2, "ba1", 1000, "savings");
		BankAccount bankAccount1 = new BankAccount(3, "ba2", 2000, "current");
		
		CreditCard creditcard = new CreditCard(4, "ca1", 2022, 12);
		CreditCard creditcard1 = new CreditCard(5, "ca2", 2024, 12);
		
		entityManager.getTransaction().begin();
	
		entityManager.persist(account);
		entityManager.persist(bankAccount);
		entityManager.persist(bankAccount1);
		entityManager.persist(creditcard);
		entityManager.persist(creditcard1);
		entityManager.getTransaction().commit();
		
		
		
	}

}
