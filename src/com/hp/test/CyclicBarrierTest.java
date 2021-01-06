package com.hp.test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class CBThread extends Thread {

	private CyclicBarrier barrier1;
	public CBThread (CyclicBarrier  barrier1) {
		this.barrier1 = barrier1;
	}
	
	public void run () {
		System.out.println(getName() + " started...");
		
		try {
			barrier1.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(getName() + " ended..");
	}
	
}

 class MyRunnable1 implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("common business logic for all threads..");
	}
	
}
public class CyclicBarrierTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CyclicBarrier barrier1 = new CyclicBarrier(2, new MyRunnable1());
		
		CBThread cBThread = new CBThread(barrier1);
		CBThread cBThread1 = new CBThread(barrier1);
		
		cBThread.start();
		cBThread1.start();
		
	}

}
