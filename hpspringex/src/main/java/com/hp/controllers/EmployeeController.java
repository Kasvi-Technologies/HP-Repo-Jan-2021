package com.hp.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import com.hp.service.EmployeeService;

public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;

	public EmployeeService getEmployeeService() {
		return employeeService;
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

}
