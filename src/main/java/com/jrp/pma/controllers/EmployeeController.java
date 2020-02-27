package com.jrp.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jrp.pma.dao.EmployeeRepository;
import com.jrp.pma.entities.Employee;
import com.jrp.pma.entities.Project;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	EmployeeRepository proRepo;
	
	@GetMapping("/new")
	public String displayEmployeeForm(Model model) {
		
		Employee aEmployee = new Employee();
		
		model.addAttribute("employee", aEmployee);
		return "new-employee";
	}
	
	@PostMapping("/save")
	public String createEmployee(Employee employee, Model model) {
		proRepo.save(employee);
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/new";
	}
	
	@GetMapping("/list")
	public String displayHome(Model model) {
		List<Employee> employees = proRepo.findAll();
		
		model.addAttribute("employeesList", employees);
		
		return "employee-list";
	}
	
}
