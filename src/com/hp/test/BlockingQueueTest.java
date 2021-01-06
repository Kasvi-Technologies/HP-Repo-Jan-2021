package com.hp.test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class Message {
	
	private String messgae;

	public String getMessgae() {
		return messgae;
	}

	public void setMessgae(String messgae) {
		this.messgae = messgae;
	}
	
}

class ProducerThread extends Thread {
	
	private BlockingQueue<Message> queue;
	
	public ProducerThread (BlockingQueue<Message> queue) {
		this.queue = queue;
	}
	
	public void run() {
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for (int i = 0; i<100; i++) {
			Message m = new Message ();
			m.setMessgae(i  + " message");
			
			try {
				System.out.println("adding element into queue:" + i);
				queue.put(m);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		Message m1 = new Message();
		m1.setMessgae("exit") ;
		try {
			queue.put(m1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}


class ConsumerThread extends Thread {
	
	private BlockingQueue<Message> queue;
	
	public ConsumerThread (BlockingQueue<Message> queue) {
		this.queue = queue;
	}
	
	public void run() {
		
		while (true) {
			Message m = null;
			try {
				
				m = queue.take();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("from consumer:" + m.getMessgae());
		
			if ("exit".equals(m.getMessgae())) {
				break;
			}
		}
		
		
	}
}



public class BlockingQueueTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BlockingQueue<Message> queue = new ArrayBlockingQueue<Message>(10);
		ProducerThread producer = new ProducerThread(queue);
		ConsumerThread consumer = new ConsumerThread(queue);
		
		consumer.start();
		producer.start();

	}

}
