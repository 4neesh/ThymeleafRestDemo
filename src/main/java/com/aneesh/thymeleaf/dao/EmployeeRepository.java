package com.aneesh.thymeleaf.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aneesh.thymeleaf.model.Employee;

//@RepositoryRestResource(path="members")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	
	//add method to sort by last name
	public List<Employee> findAllByOrderByLastNameAsc();
}
