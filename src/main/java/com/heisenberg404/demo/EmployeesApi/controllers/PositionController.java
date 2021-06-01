package com.heisenberg404.demo.EmployeesApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.heisenberg404.demo.EmployeesApi.responses.PositionsResp;
import com.heisenberg404.demo.EmployeesApi.services.PositionService;

@RestController
public class PositionController {
	
	@Autowired
	PositionService positionService;

	
	/*
	 * Get all positions
	 */
	@GetMapping("/positions")
	List<PositionsResp> getAllPositions() {
		return positionService.getAllPositions();
		
	}
}
