package com.aneesh.thymeleaf.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aneesh.thymeleaf.model.Employee;
import com.aneesh.thymeleaf.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	//the next 3 lines allow us to use the employee service to obtain
	//data from the database.
	private EmployeeService employeeService;
	
	public EmployeeController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}
	
	
	@GetMapping("/list")
	public String getEmployees(Model model){
		List<Employee> theEmployeeList = employeeService.findAll();
		
		model.addAttribute("employees", theEmployeeList);
		return "employees/list-employees";
	}
	
	@GetMapping("/showFormForAdd")
	public String showformForAdd(Model theModel) {
		
		Employee theEmployee = new Employee();
		theModel.addAttribute("employee", theEmployee);
		return "employees/employeeForm";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {
		
		employeeService.saveEmployee(theEmployee);
		return "redirect:/employees/list";
		
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int id,
									Model theModel) {
		Employee theEmployee = employeeService.findEmployee(id);
		theModel.addAttribute("employee", theEmployee);
		return "employees/employeeForm";
	}
	
	@GetMapping("/deleteEmployee")
	public String deleteEmployee(@RequestParam("employeeId") int id) {
		
		employeeService.deleteEmployee(id);
		return "redirect:/employees/list";

	}
	
}
