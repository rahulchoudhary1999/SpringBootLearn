package com.choudhary.rahul.dao;

import org.springframework.data.repository.CrudRepository;

import com.choudhary.rahul.entity.Employee;


public interface EmployeeRepository extends CrudRepository<Employee,Integer>{
	
}
