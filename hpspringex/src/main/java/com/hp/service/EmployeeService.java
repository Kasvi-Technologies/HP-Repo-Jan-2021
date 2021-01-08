package com.hp.service;

import com.hp.beans.Employee;
import com.hp.dao.EmployeeDAO;

public class EmployeeService {
	
	
	public EmployeeService() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployeeService(EmployeeDAO employeeDAO) {
		super();
		System.out.println("calling construcor based DI");
		this.employeeDAO = employeeDAO;
	}

	private EmployeeDAO employeeDAO;

	public EmployeeDAO getEmployeeDAO() {
		return employeeDAO;
	}

	public void setEmployeeDAO(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}
	
	public void insertEmployee (Employee emp) {
		//Service logic to insert employee..
		//Business logic..........
		
		System.out.println("Service:: insert Employee");
		
		this.employeeDAO.insertEmployee(emp);
	}

}
