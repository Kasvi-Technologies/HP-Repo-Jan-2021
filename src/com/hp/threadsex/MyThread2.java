package com.hp.threadsex;

public class MyThread2 extends Thread{
	
	//run method will be executed in background to
	//achieve parallel processing
	
	public void run() {
		System.out.println("Executing run method of " + getName());
		for (int i=100; i<200; i++) {
			
			System.out.println(i);
			
			try {
				Thread.sleep(300); //300ms
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		System.out.println("completed run method of " + getName());
	}

}
