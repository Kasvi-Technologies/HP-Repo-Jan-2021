package com.hp.test;

class MyRunnable implements Runnable {

	public void run () {
		System.out.println("running....");
	}
}

public class RunnableTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyRunnable myRunnable = new MyRunnable();
		new Thread (myRunnable).start();
		
		
	}

}
