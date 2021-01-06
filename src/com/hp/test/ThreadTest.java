package com.hp.test;

import com.hp.threadsex.MyThread1;
import com.hp.threadsex.MyThread2;

public class ThreadTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyThread1 myThread1 = new MyThread1();
		myThread1.setName("First Thread");
		MyThread2 myThread2 = new MyThread2();
		myThread2.setName("Second Thread");
		
		myThread1.start();
		
		myThread2.start();
		
	}

}
