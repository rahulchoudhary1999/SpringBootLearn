package com.choudhary.rahul.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.choudhary.rahul.dao.EmployeeRepository;
import com.choudhary.rahul.entity.Employee;
@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
private EmployeeRepository employeeRepository;
	
	  @PostMapping("/addEmployee")
	  Employee addEmployee(@RequestBody Employee employee) {
	    return employeeRepository.save(employee);
	  }
	  
	  @GetMapping("/getEmployees")
	  public List<Employee> getEmployees() {
	    return (List<Employee>) employeeRepository.findAll();
	  }
	  
	  @PutMapping("/updateEmployee/{id}")
	 void updateEmployee(@RequestBody Employee employee, @PathVariable int id) 
	  {
		  Optional<Employee> optional=employeeRepository.findById(id);
		  if(optional.isPresent())
		  {
			  Employee e=optional.get();
			  e.setFirstName(employee.getFirstName());
			  e.setLastName(employee.getLastName());
			  e.setDesignation(employee.getDesignation());
			  e.setAge(employee.getAge());
			  employeeRepository.save(e);
		  }
	  }
	  
	  @DeleteMapping("/deleteEmployee/{id}")
	  void deleteEmployee(@PathVariable int id) {
	    employeeRepository.deleteById(id);
	  }
}
