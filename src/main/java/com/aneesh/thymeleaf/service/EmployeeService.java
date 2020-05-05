package com.aneesh.thymeleaf.service;

import java.util.List;

import com.aneesh.thymeleaf.model.Employee;

public interface EmployeeService {

	public List<Employee> findAll();

	public void saveEmployee(Employee employee);

	public Employee findEmployee(int theId);

	public void deleteEmployee(int theId);
	
}
