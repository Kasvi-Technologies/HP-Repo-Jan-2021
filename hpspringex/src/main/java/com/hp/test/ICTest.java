package com.hp.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hp.beans.Employee;
import com.hp.service.EmployeeService;

public class ICTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext context = 
				new ClassPathXmlApplicationContext("beans.xml");
		
		Employee employee = (Employee) context.getBean("emp");
		
		System.out.println(employee);
		
		Employee employee1 = (Employee) context.getBean("employee");
		
		System.out.println(employee1);		
		
		EmployeeService employeeService = (EmployeeService) context.getBean("employeeService");
		employeeService.insertEmployee(employee1);
		
		EmployeeService employeeServiceUsingCons = (EmployeeService) context.getBean("employeeServiceUsingCons");
		employeeServiceUsingCons.insertEmployee(employee1);
		
		
	}

}





