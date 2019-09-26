package com.thangnv.springboot.mockproject.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.thangnv.springboot.mockproject.mapper.EmployeeMapper;
import com.thangnv.springboot.mockproject.model.Employees;

@Controller
public class EmployeeController {

	private EmployeeMapper mapper;

	public EmployeeController(EmployeeMapper mapper) {
		super();
		this.mapper = mapper;
	}

	@GetMapping("/login")
	public String homePage(Model model) {
		return "home";
	}
	@GetMapping("/")
	public String home(Model model) {
		return "home";
	}


	@GetMapping("/employee/list")
	public String listemp(Model model) {
		model.addAttribute("employees", this.mapper.findAllEmployee());
		return "employees/listemployee";
	}

	@GetMapping("/employee/listhasdepart")
	public String listempHasDepart(Model model) {
		model.addAttribute("employees", this.mapper.findAllEmployeeExistDepartment());
		return "employees/listemployee";
	}

	@GetMapping("/employee/seachByName")
	public String seachByDepartment(@RequestParam("departname") String departname, Model model) {

		model.addAttribute("employees", this.mapper.findAllByDepart(departname));
		return "employees/listemployee";
	}

	@GetMapping("/employee/showformAdd")
	public String addEmployee(Model model) {
		Employees emp = new Employees();
		model.addAttribute("employee", emp);
		return "employees/employee-form";
	}

	@GetMapping("/employee/showformUpdate")
	public String updateEmployee(@RequestParam("employeeID") int EmployeeID, Model model) {
		Employees emp = this.mapper.findEmployeeByID(EmployeeID);
		model.addAttribute("employee", emp);
		return "employees/employee-form";
	}

	@GetMapping("/employee/showformDelete")
	public String deleteEmployee(@RequestParam("employeeID") int EmployeeID, Model model) {
		Employees emp = this.mapper.findEmployeeByID(EmployeeID);
		model.addAttribute("employee", emp);
		return "employees/comfirm-delete";
	}
}
