package com.aneesh.thymeleaf.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aneesh.thymeleaf.dao.EmployeeRepository;
import com.aneesh.thymeleaf.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	
private EmployeeRepository employeeRepository;
	
@Autowired
public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
	employeeRepository = theEmployeeRepository;		
}
	
	
	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAllByOrderByLastNameAsc();
	}

	@Override
	public Employee findEmployee(int id) {
		
		Optional<Employee> result = employeeRepository.findById(id);
		Employee theEmployee = null;
		if(result.isPresent()) {
			theEmployee = result.get();
			}
		else {
			throw new RuntimeException("Did not find employee id - " + id);
		}
		return theEmployee;
	}

	@Override
	public void saveEmployee(Employee employee) {
		employeeRepository.save(employee);

	}

	@Override
	public void deleteEmployee(int id) {
		employeeRepository.deleteById(id);

	}

}

