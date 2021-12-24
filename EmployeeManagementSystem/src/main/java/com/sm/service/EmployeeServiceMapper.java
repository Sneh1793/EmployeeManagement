package com.sm.service;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.sm.api.EmployeeGetModel;
import com.sm.repository.EmployeeEntity;

@Mapper
public interface EmployeeServiceMapper  {
//	@Mapping(source= "empid", target= "employeeid")
	EmployeeEntity fromEmployeeBotoEmployeeEntity(EmployeeBO employeeBo);
	
	@Mapping(source= "employeeId", target= "empid")
	EmployeeGetBO fromEmployeeEntityToEmployeeGetBO(EmployeeEntity employeeEntity);

}
