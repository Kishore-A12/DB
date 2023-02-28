package com.db.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.db.model.Employee;
import com.db.repository.EmployeeRepository;

@RestController
@RequestMapping("/employee")
public class WebController {
	
	@Autowired
	EmployeeRepository repository;
	
	@PostMapping("/save")
	public HttpStatus insertEmployee(@RequestBody Employee employee){
		boolean status = repository.save(employee) != null;		
		return status? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
	}
	
	
	@GetMapping("/findall")
	public List<Employee> findAll(){
		
		
		return (List<Employee>) repository.findAll();
	}
	
	@GetMapping("/findbyid")
	public Optional<Employee> findById(@RequestParam("id") long id){
		Optional<Employee> result = repository.findById(id);
		return result;
	}
	
	@GetMapping("/findbylastname")
	public List<Employee> fetchDataByLastName(@RequestParam("lastname") String lastName){
		 		
		return repository.findByLastName(lastName);
	}
	
	@GetMapping("/findbyage")
	public List<Employee> fetchDataByAge(@RequestParam("age") int age){
		 		
		return repository.findByAge(age);
	}
}

