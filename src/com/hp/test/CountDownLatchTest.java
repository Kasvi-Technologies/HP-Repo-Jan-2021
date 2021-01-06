package com.hp.test;

import java.util.concurrent.CountDownLatch;

class WT extends Thread {

	private CountDownLatch latch;
	
	public WT(CountDownLatch latch) {
		this.latch = latch;
	}
	
	public void run () {
		
		System.out.println("Before await..");
		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("completion of await..");
	}
	
}


class DT extends Thread {

	private CountDownLatch latch;
	
	public DT(CountDownLatch latch) {
		this.latch = latch;
	}
	
	public void run () {
		
		System.out.println("count down started....");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		latch.countDown();
		latch.countDown();
		latch.countDown();
		latch.countDown();
	//	latch.countDown();
		
		System.out.println("count down completed..." + latch.getCount());
	}
	
}


public class CountDownLatchTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CountDownLatch latch = new CountDownLatch(5);
		WT wt = new WT(latch);
		DT dt = new DT(latch);
		
		wt.start();
		dt.start();
		
	}

}
