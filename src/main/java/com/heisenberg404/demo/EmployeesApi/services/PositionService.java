package com.heisenberg404.demo.EmployeesApi.services;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.heisenberg404.demo.EmployeesApi.entities.Employee;
import com.heisenberg404.demo.EmployeesApi.entities.Position;
import com.heisenberg404.demo.EmployeesApi.repository.EmployeeRepository;
import com.heisenberg404.demo.EmployeesApi.repository.PersonRepository;
import com.heisenberg404.demo.EmployeesApi.repository.PositionRepository;
import com.heisenberg404.demo.EmployeesApi.responses.PositionsResp;

@Service
public class PositionService {
	
	private final EmployeeRepository employeeRepository;
	private final PositionRepository positionRepository;
	
	public PositionService(EmployeeRepository employeeRepository, PositionRepository positionRepository,
			PersonRepository personRepository) {
		this.employeeRepository = employeeRepository;
		this.positionRepository = positionRepository;
	}
	
	 /*
	 * Get all positions
	 */
	public List<PositionsResp> getAllPositions() {
		List<Position> positions = positionRepository.findAll();
		return positions.stream().map(position -> {
			PositionsResp positionsResp = new PositionsResp();
			positionsResp.setId(position.getId());
			positionsResp.setName(position.getName());
			positionsResp.setEmployees(employeeRepository.findAll().stream()
					.filter(employee -> employee.getPosition().getName().equalsIgnoreCase(position.getName()))
					.sorted(Comparator.comparingInt(Employee::getSalary).reversed())
					.collect(Collectors.toList()));
			return positionsResp;
		}).collect(Collectors.toList());
		
		
		
	}

}
