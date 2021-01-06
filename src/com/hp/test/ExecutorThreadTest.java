package com.hp.test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class MyRunnable5 implements Runnable {

	public void run () {
		System.out.println("running....");
	}
}

class MyCallble implements Callable<String> {
	
	public String call() {
		
		System.out.println("call method started..");
		return "Hello............";
	}
}

class Employee {
	
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private String name;
	
}

public class ExecutorThreadTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ExecutorService excutorservice = Executors.newFixedThreadPool(10);
		
		excutorservice.execute(new MyRunnable5());
		
		//Anonymous inner class
		
		Runnable run1 = new Runnable() {
			public void run() {
				System.out.println("run1 ..............");
			}
		};
		
		excutorservice.execute(run1);
		
		Future f = excutorservice.submit(run1);
		
		try {
			System.out.println(f.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Future<String> f1 = excutorservice.submit(new MyCallble());
		try {
			System.out.println("return value from call:" + f1.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Callable callable = new Callable<Employee>() {
			
			public Employee call() {
				Employee emp = new Employee();
				
				emp.setId(10);
				emp.setName("asdsad");
				return emp;
			}
		};
		
		
		Future<Employee> f2 = excutorservice.submit(callable);
		try {
			Employee e = f2.get();
			System.out.println("return value from call:" + e.getId() + " " + e.getName());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		excutorservice.shutdown();
		
	}

}
