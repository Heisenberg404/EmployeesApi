package com.heisenberg404.demo.EmployeesApi.responses;

import java.util.List;

import com.heisenberg404.demo.EmployeesApi.entities.Employee;

public class PositionsResp {
	
	private Long Id;
	private String name;
	private List<Employee> employees;
	
	public PositionsResp(Long id, String name, List<Employee> employees) {
		super();
		Id = id;
		this.name = name;
		this.employees = employees;
	}

	public PositionsResp() {
		super();
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
}
