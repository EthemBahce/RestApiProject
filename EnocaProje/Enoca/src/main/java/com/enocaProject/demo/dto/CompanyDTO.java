package com.enocaProject.demo.dto;

import java.util.List;

import com.enocaProject.demo.entities.Employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyDTO {
	 
	 private Long company_id;
	
	 private String company_name;
	
	 private List<Employee> employees;

}
