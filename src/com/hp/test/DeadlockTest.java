package com.hp.test;

class FirstThread extends Thread {
	
	private Deadlock d = null;
	public FirstThread (Deadlock d) {
		this.d = d;
	}
	public void run() {
		d.method1();
	}
}

class SecondThread extends Thread {
	
	private Deadlock d = null;
	public SecondThread (Deadlock d) {
		this.d = d;
	}
	public void run() {
		d.method2();
	}
}


class Deadlock {

	Object obj = new Object();
	String str = new String();
	
	public void method1 () {
		
		System.out.println("method1....");
		
		synchronized(obj){
			System.out.println("Thread utility method1 started obtain the lock on obj");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("Thread utility method1 trying for lock on str");
			synchronized(str) {
				System.out.println("Thread utility display2 ended business logic for ");
			}
			
		}

	}
	
	public void method2 () {
		
		System.out.println("method2....");
		
		synchronized(str){
			System.out.println("Thread utility method2 started obtain the lock on str");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("Thread utility method2 trying for lock on obj");
			synchronized(obj) {
				System.out.println("Thread utility display2 ended business logic for ");
			}
			
		}

	}
	

}

public class DeadlockTest {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Deadlock deadlock = new Deadlock();
		FirstThread f = new FirstThread(deadlock);
		SecondThread s = new SecondThread(deadlock);
		
		f.start();
		s.start();
	}

}
