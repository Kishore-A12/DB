package com.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.db.model.Employee;



@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long>{
	
	
	List<Employee> findByLastName(String lastName);
	
	@Query("SELECT e FROM Employee e WHERE e.age = :age")
    public List<Employee> findByAge(@Param("age") int age);
}
