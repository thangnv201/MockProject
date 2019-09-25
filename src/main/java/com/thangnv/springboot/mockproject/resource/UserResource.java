package com.thangnv.springboot.mockproject.resource;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thangnv.springboot.mockproject.mapper.EmployeeMapper;
import com.thangnv.springboot.mockproject.model.Employees;

@RestController
@RequestMapping("employee/rest/")
public class UserResource {

	private EmployeeMapper mapper;

	public UserResource(EmployeeMapper mapper) {
		super();
		this.mapper = mapper;
	}

	@GetMapping("/all")
	public List<Employees> findAllEmployee() {
		return this.mapper.findAllEmployee();
	}

	@GetMapping("/allexistdepartment")
	public List<Employees> findAllEmployeeExistDepartment() {
		return this.mapper.findAllEmployeeExistDepartment();
	}

	@GetMapping("/employeebydepartment")
	public List<Employees> all(@RequestParam("depart") String departname) {
		return this.mapper.findAllByDepart(departname);
	}

	@PostMapping("/save")
	public void save(@ModelAttribute Employees employees, HttpServletResponse response) {
		if (employees.getEmp_id() == null)
			this.mapper.insertEmployee(employees);
		else this.mapper.updateEmployee(employees);
		try {
			response.sendRedirect("/employee/list");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    @PostMapping("/delete")
    public void delete(@ModelAttribute Employees employees, HttpServletResponse response) {
    	this.mapper.deleteEmployeeByID(employees.getEmp_id());
    	try {
			response.sendRedirect("/employee/list");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}
