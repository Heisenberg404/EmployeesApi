package com.heisenberg404.demo.EmployeesApi.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.heisenberg404.demo.EmployeesApi.entities.Employee;
import com.heisenberg404.demo.EmployeesApi.entities.Person;
import com.heisenberg404.demo.EmployeesApi.entities.Position;
import com.heisenberg404.demo.EmployeesApi.repository.EmployeeRepository;
import com.heisenberg404.demo.EmployeesApi.repository.PersonRepository;
import com.heisenberg404.demo.EmployeesApi.repository.PositionRepository;

@Configuration
public class LoadDatabase {
	
	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
	

	@Bean
	CommandLineRunner initDataBase(EmployeeRepository employeeRepository, PersonRepository personRepository,
			PositionRepository positionRepository) {
		return args -> {
			Position newPosition = new Position("Dev");
			Position positionSaved = positionRepository.save(newPosition);
			Person newPerson1 = new Person("Tom", "Tommas", "Street 13", "3029099090", "New York");
			Person person1Saved = personRepository.save(newPerson1);
			Person newPerson2 = new Person("Tommy", "Tommason", "Street 14", "3029099091", "San Francisco");
			Person person2Saved = personRepository.save(newPerson2);
			log.info("Preloading " + employeeRepository.save(new Employee(person1Saved, positionSaved, 10000)));
			log.info("Preloading " + employeeRepository.save(new Employee(person2Saved, positionSaved, 12000)));
		};
	}
}
