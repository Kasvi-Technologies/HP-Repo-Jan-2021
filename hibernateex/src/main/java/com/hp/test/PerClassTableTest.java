package com.hp.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.hp.entities.Account;
import com.hp.entities.AccountJoined;
import com.hp.entities.AccountPerClass;
import com.hp.entities.BankAccount;
import com.hp.entities.BankAccountJoined;
import com.hp.entities.BankAccountPerClass;
import com.hp.entities.CreditCard;
import com.hp.entities.CreditCardJoined;
import com.hp.entities.CreditCardPerClass;
import com.hp.entities.Product;

public class PerClassTableTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManagerFactory  emf= Persistence.createEntityManagerFactory("HibernatePU");
		
		//obtain the connection from pool of connection objects
		//similar to Connection 
		EntityManager entityManager = emf.createEntityManager();
		
		AccountPerClass account = new AccountPerClass(1, "sample");
		
		BankAccountPerClass bankAccount = new BankAccountPerClass(2, "ba1", 1000, "savings");
		BankAccountPerClass bankAccount1 = new BankAccountPerClass(3, "ba2", 2000, "current");
		
		CreditCardPerClass creditcard = new CreditCardPerClass(4, "ca1", 2022, 12);
		CreditCardPerClass creditcard1 = new CreditCardPerClass(5, "ca2", 2024, 12);
		
		entityManager.getTransaction().begin();
	
		entityManager.persist(account);
		entityManager.persist(bankAccount);
		entityManager.persist(bankAccount1);
		entityManager.persist(creditcard);
		entityManager.persist(creditcard1);
		entityManager.getTransaction().commit();
		
		
		
	}

}
