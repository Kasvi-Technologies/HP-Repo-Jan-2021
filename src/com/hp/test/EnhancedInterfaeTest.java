package com.hp.test;

class ChildClass implements EnhacedInterfacesExample {

	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("display method");
	}
	
}

public class EnhancedInterfaeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EnhacedInterfacesExample enhacedInterfacesExample = new ChildClass();
		System.out.println(enhacedInterfacesExample.sum(5, 6));
		enhacedInterfacesExample.display();
		EnhacedInterfacesExample.evaluate();
	}

}
