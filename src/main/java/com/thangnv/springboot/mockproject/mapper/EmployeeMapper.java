package com.thangnv.springboot.mockproject.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.thangnv.springboot.mockproject.model.Employees;

public interface EmployeeMapper {

	List<Employees> findAllEmployee();
	List<Employees> findAllEmployeeExistDepartment();
	List<Employees> findAllByDepart(@Param("departname") String departname);
	void insertEmployee(Employees employees);
	void updateEmployee(Employees employees);
	Employees findEmployeeByID(int employeeID);
	void deleteEmployeeByID(int id);
}
