package com.hp.test;

public interface EnhacedInterfacesExample {
	
	default int sum (int a, int b) {
		return a + b;
	}
	
	static void evaluate () {
		System.out.println("in static method of interface");
	}
	public void display();

}
