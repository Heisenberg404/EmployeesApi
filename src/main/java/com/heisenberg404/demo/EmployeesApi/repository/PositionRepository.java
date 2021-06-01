package com.heisenberg404.demo.EmployeesApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.heisenberg404.demo.EmployeesApi.entities.Position;

public interface PositionRepository extends JpaRepository<Position, Long> {

}
