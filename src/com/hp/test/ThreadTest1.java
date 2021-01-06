package com.hp.test;

import com.hp.threadsex.MyThread1;
import com.hp.threadsex.MyThread2;
import com.hp.threadsex.ThreadUtility;

public class ThreadTest1 {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadUtility threadUtility1 = new ThreadUtility();
		ThreadUtility threadUtility2 = new ThreadUtility();
		
		MyThread1 myThread1 = new MyThread1(threadUtility1);
		myThread1.setName("First Thread");
		MyThread2 myThread2 = new MyThread2(threadUtility2);
		myThread2.setName("Second Thread");
		
		myThread1.start();
		
		myThread2.start();
		
	}

}
