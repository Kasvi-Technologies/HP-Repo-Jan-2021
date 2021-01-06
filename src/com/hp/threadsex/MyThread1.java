package com.hp.threadsex;

public class MyThread1 extends Thread{
	
	//run method will be executed in background to
	//achieve parallel processing
	
	private ThreadUtility threadUtility = null;
	
	public MyThread1 (ThreadUtility threadUtility) {
		this.threadUtility = threadUtility;
	}
	
	
	public void run() {
		System.out.println("Executing run method of " + getName());
		for (int i=0; i<100; i++) {
			
			System.out.println(i);
			
			if (i == 50) {
				threadUtility.display1(i);
			}
			
			try {
				Thread.sleep(300); //500ms
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("completed run method of " + getName());
	}

}
