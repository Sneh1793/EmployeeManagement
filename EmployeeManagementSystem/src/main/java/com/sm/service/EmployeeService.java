package com.sm.service;

public interface EmployeeService {

	
	 int saveEmployee(EmployeeBO employeeBo) ;
	 
	 EmployeeGetBO getEmployee(int empid, String firstName, String lastName);
}
