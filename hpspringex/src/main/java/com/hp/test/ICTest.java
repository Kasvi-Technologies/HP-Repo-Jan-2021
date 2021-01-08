package com.hp.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hp.beans.Employee;

public class ICTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext context = 
				new ClassPathXmlApplicationContext("beans.xml");
		
		Employee employee = (Employee) context.getBean("emp");
		
		System.out.println(employee);
		
		
		
	}

}
