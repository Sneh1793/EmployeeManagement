package com.sm.service;


import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sm.api.EmployeeGetModel;
import com.sm.remote.AddressDetailDTO;
import com.sm.remote.EmployeeAddressRemoteService;

import com.sm.repository.EmployeeDao;
import com.sm.repository.EmployeeEntity;

import ch.qos.logback.classic.Logger;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

private EmployeeDao employeeDao;
	
private EmployeeServiceMapper employeeServiceMapper;

private EmployeeAddressRemoteService employeeAddressRemoteService;
	
public EmployeeServiceImpl(EmployeeDao employeeDao, EmployeeServiceMapper employeeServiceMapper, EmployeeAddressRemoteService employeeAddressRemoteService) {
	
	this.employeeDao = employeeDao;
	this.employeeServiceMapper = employeeServiceMapper;
	this.employeeAddressRemoteService= employeeAddressRemoteService;
}

	@Override
	public int saveEmployee(EmployeeBO employeeBo) {
	
	EmployeeEntity employeeEntity = employeeServiceMapper.fromEmployeeBotoEmployeeEntity(employeeBo);
		
	log.info("Saving details for employee {}", employeeEntity);
	EmployeeEntity employeeEntitySave =	employeeDao.save(employeeEntity);
	
	log.info("Saved successfully for employee id {}", employeeEntitySave.getEmployeeId());
	return employeeEntitySave.getEmployeeId();
		
	}

	@Override
	public EmployeeGetBO getEmployee(int empid, String firstName, String lastName) {
	
	log.info("getting employee data for employee id {} and First_Name {}", empid, firstName);	
	EmployeeEntity employeeEntity	= employeeDao.findByEmployeeIdAndFirstNameAndLastName(empid, firstName, lastName);
	
	EmployeeGetBO employeeGetBO= employeeServiceMapper.fromEmployeeEntityToEmployeeGetBO(employeeEntity)	;
	
	List<AddressDetailDTO> addressDetailDTOs = employeeAddressRemoteService.getEmployeeAddress(employeeGetBO.getPinCode());
	log.info("getting list of postOffices as per the pincode", addressDetailDTOs);
	addressDetailDTOs.sort(Comparator.comparing(AddressDetailDTO::getName).reversed());
	 
	   AddressBO addressBO= employeeServiceMapper.fromAddressDetailDTOToAddressBO(addressDetailDTOs.get(0));
	employeeGetBO.setAddressBO(addressBO);
	return employeeGetBO;
	}
	

}
