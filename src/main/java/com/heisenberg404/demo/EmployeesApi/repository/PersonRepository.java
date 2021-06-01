package com.heisenberg404.demo.EmployeesApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.heisenberg404.demo.EmployeesApi.entities.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{

}
