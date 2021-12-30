package com.sm.api;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.sm.service.AddressBO;
import com.sm.service.EmployeeBO;
import com.sm.service.EmployeeGetBO;



@Mapper
public interface EmployeeApiMapper {

	EmployeeBO fromEmployeeModelToEmployeeBO(EmployeeModel employeeModel );
	
	@Mapping(source= "empid", target= "employeeId")
	@Mapping(source= "addressBO", target= "addressModel")
	EmployeeGetModel fromEmployeeGetBOToEmployeeGetModel(EmployeeGetBO employeeGetBO);
	
	AddressModel fromAddressBOToAddressModel(AddressBO addressBO);
}
