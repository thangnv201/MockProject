package com.thangnv.springboot.mockproject.resource;


import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thangnv.springboot.mockproject.mapper.EmployeeMapper;
import com.thangnv.springboot.mockproject.model.Employees;

@RestController
@RequestMapping("/rest/emp")
public class UserResource {
 
	private EmployeeMapper mapper ;
	
	public UserResource(EmployeeMapper mapper) {
		super();
		this.mapper = mapper;
	}

	@GetMapping("/all")
	public List<Employees> getall(){
		return this.mapper.findAll();
	}
}
