package com.heisenberg404.demo.EmployeesApi.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.heisenberg404.demo.EmployeesApi.entities.Employee;
import com.heisenberg404.demo.EmployeesApi.entities.Person;
import com.heisenberg404.demo.EmployeesApi.entities.Position;
import com.heisenberg404.demo.EmployeesApi.exceptions.EmployeeNotFoundException;
import com.heisenberg404.demo.EmployeesApi.repository.EmployeeRepository;
import com.heisenberg404.demo.EmployeesApi.repository.PersonRepository;
import com.heisenberg404.demo.EmployeesApi.repository.PositionRepository;

@Service
public class EmployeesService {
	
	private final EmployeeRepository employeeRepository;
	private final PersonRepository personRepository;
	private final PositionRepository positionRepository;
	
	public EmployeesService(EmployeeRepository employeeRepository, PositionRepository positionRepository,
			PersonRepository personRepository) {
		this.employeeRepository = employeeRepository;
		this.personRepository = personRepository;
		this.positionRepository = positionRepository;
	}
	
	/*
	 * Get all employees 
	 */
	public List<Employee> all(Optional<String> position, Optional<String> name) {
		// not filter at all
		List<Employee> response = employeeRepository.findAll();
		if (position.isPresent()) {
			response = response.stream().filter(employee -> employee.getPosition().getName().equalsIgnoreCase(position.get())).collect(Collectors.toList());
		}
		if (name.isPresent()) {
			response = response.stream().filter(employee -> employee.getPerson().getName().equalsIgnoreCase(name.get())).collect(Collectors.toList());
		}
		
		return response;
	}

	/*
	 * Save a new employee
	 */
	public Employee newEmployee(Employee employee) {
		Person newPerson = personRepository.save(employee.getPerson());
		Position newPosition = positionRepository.save(employee.getPosition());
		
		employee.setPerson(newPerson);
		employee.setPosition(newPosition);
		return employeeRepository.save(employee);
	}
	
	/**
	 * get a single item
	 */
	public Employee one(@PathVariable Long id) {
		return employeeRepository.findById(id).orElseThrow(() -> 
		new EmployeeNotFoundException(id));
	}
	
	/**
	 * update an item
	 */
	public Employee replaceEmployee(Employee newEmployee, Long id) {
		return employeeRepository.findById(id)
				.map(employee -> {
					Person newPerson = personRepository.save(newEmployee.getPerson());
					Position newPosition = positionRepository.save(newEmployee.getPosition());
					
					newEmployee.setPerson(newPerson);
					newEmployee.setPosition(newPosition);
					
					employee.setPerson(newEmployee.getPerson());
					employee.setPosition(newEmployee.getPosition());
					employee.setSalary(newEmployee.getSalary());
					return employeeRepository.save(employee);
				}).orElseThrow(() -> 
				new EmployeeNotFoundException(id));
	}
	
	/**
	 * Delete a single item
	 */
	public void deleteEmployee(Long id) {
		employeeRepository.deleteById(id);
	}

}
