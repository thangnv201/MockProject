package com.thangnv.springboot.mockproject.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.thangnv.springboot.mockproject.model.Employees;

@Mapper
public interface EmployeeMapper {

	@Select("SELECT * FROM mockDB.employee;")
	List<Employees> findAll();
	

}
