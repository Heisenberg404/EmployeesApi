package com.heisenberg404.demo.EmployeesApi.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.heisenberg404.demo.EmployeesApi.entities.Employee;
import com.heisenberg404.demo.EmployeesApi.services.EmployeesService;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeesService employeeService;
	
	
	/*
	 * Get all employees 
	 */
	@GetMapping("/employees")
	List<Employee> all(@RequestParam Optional<String> position, @RequestParam Optional<String> name) {
		return employeeService.all(position, name);
	}
	
	/*
	 * Save a new employee
	 */
	@PostMapping("/employees")
	Employee newEmployee(@RequestBody Employee employee) {
		return employeeService.newEmployee(employee);
	}
	
	/**
	 * get a single item
	 */
	@GetMapping("/employees/{id}")
	Employee one(@PathVariable Long id) {
		return employeeService.one(id);
	}
	
	/**
	 * update an item
	 */
	@PutMapping("/employees/{id}")
	Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {
		return employeeService.replaceEmployee(newEmployee, id);
	}
	
	/**
	 * Delete a single item
	 */
	@DeleteMapping("/employees/{id}")
	void deleteEmployee(@PathVariable Long id) {
		employeeService.deleteEmployee(id);
	}

}
