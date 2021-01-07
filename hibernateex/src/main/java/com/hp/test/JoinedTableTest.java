package com.hp.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.hp.entities.Account;
import com.hp.entities.AccountJoined;
import com.hp.entities.BankAccount;
import com.hp.entities.BankAccountJoined;
import com.hp.entities.CreditCard;
import com.hp.entities.CreditCardJoined;
import com.hp.entities.Product;

public class JoinedTableTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManagerFactory  emf= Persistence.createEntityManagerFactory("HibernatePU");
		
		//obtain the connection from pool of connection objects
		//similar to Connection 
		EntityManager entityManager = emf.createEntityManager();
		
		AccountJoined account = new AccountJoined(1, "sample");
		
		BankAccountJoined bankAccount = new BankAccountJoined(2, "ba1", 1000, "savings");
		BankAccountJoined bankAccount1 = new BankAccountJoined(3, "ba2", 2000, "current");
		
		CreditCardJoined creditcard = new CreditCardJoined(4, "ca1", 2022, 12);
		CreditCardJoined creditcard1 = new CreditCardJoined(5, "ca2", 2024, 12);
		
		entityManager.getTransaction().begin();
	
		entityManager.persist(account);
		entityManager.persist(bankAccount);
		entityManager.persist(bankAccount1);
		entityManager.persist(creditcard);
		entityManager.persist(creditcard1);
		entityManager.getTransaction().commit();
		
		
		
	}

}
