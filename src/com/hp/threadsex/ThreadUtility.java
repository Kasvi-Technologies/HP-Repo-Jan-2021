package com.hp.threadsex;

public class ThreadUtility {
	
	// only one thread has access to this particular method at any point of time
	// t1 -> threadUtility  -> display 
	//Here t1 will obtain the lock on threadUtility object and try to execute the business logic
	
	//meanwhile t2 -> threadUtility -> display
	// t2 will be in waiting state until t1 releases the lock on threadUtility object
	public synchronized void display(int i) {
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Thread utility business logic for " + i);
	}

	// lock is on threadUtility object
	//t2 -> will be in waiting state until t1 releases the lock
	public synchronized void display1(int i) {
		System.out.println("Thread utility display1 started");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Thread utility display1  ended business logic for " + i);
	}

public  synchronized void display2(int i) {
	System.out.println("Thread utility display2 started");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Thread utility display2 ended business logic for " + i);
	}

}
