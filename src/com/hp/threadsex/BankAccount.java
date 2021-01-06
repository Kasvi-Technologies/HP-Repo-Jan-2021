package com.hp.threadsex;

//inter thread communication is acheived using wait znd notify methods..
public class BankAccount {
	
	private int amount;
	
	public BankAccount (int amount) {
		this.amount = amount;
	}
	
	public synchronized void withdraw (int withdrawAmount) {
		
		System.out.println("withdraw method calling with " + withdrawAmount);
		
		if (withdrawAmount > amount) {
			System.out.println("withdraw amount is more and so it is waiting for another "
					+ "thread to deposit amount");
			try {
				Thread.sleep(2000);
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("some one deposited the amount..");
			this.amount = this.amount - withdrawAmount;
			System.out.println("final amount after withdrawel.." + this.amount);
			
		}
	}
	
	public synchronized void deposit (int depositAmount) {
		
		System.out.println("deposit method calling with " + depositAmount);
		
		this.amount = this.amount + depositAmount;
		notify();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("deposit method completed...");
		
	}

}
