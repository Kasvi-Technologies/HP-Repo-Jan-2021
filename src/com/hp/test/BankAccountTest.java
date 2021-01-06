package com.hp.test;

import com.hp.threadsex.BankAccount;

class WithdrawThread extends Thread {
	
	private BankAccount bankAccount;
	
	public WithdrawThread (BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}
	
	public void run () {
		System.out.println("calling withdraw ...");
		
		bankAccount.withdraw(1000);
		
		System.out.println("completed withdraw ...");
	}
}

class DepositThread extends Thread {
	
	private BankAccount bankAccount;
	
	public DepositThread (BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}
	
	public void run () {
		System.out.println("calling deposit ...");
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		bankAccount.deposit(2000);
		
		System.out.println("completed deposit ...");
	}
}

public class BankAccountTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BankAccount bankAccount = new BankAccount(500);
		WithdrawThread wt = new WithdrawThread(bankAccount);
		DepositThread dt = new DepositThread(bankAccount);
		
		wt.start();
		dt.start();

	}

}
