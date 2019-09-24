package com.thangnv.springboot.mockproject;

import org.apache.ibatis.type.MappedTypes;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.thangnv.springboot.mockproject.model.Employees;


@MappedTypes(Employees.class)
@MapperScan("com.thangnv.springboot.mockproject.mapper")
@SpringBootApplication
public class MockprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MockprojectApplication.class, args);
	}

}
