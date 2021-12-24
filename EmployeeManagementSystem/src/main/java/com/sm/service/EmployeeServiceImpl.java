package com.sm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sm.api.EmployeeGetModel;
import com.sm.repository.EmployeeDao;
import com.sm.repository.EmployeeEntity;

import ch.qos.logback.classic.Logger;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

private EmployeeDao employeeDao;
	
private EmployeeServiceMapper employeeServiceMapper;

	public EmployeeServiceImpl(EmployeeDao employeeDao, EmployeeServiceMapper employeeServiceMapper) {
	
	this.employeeDao = employeeDao;
	this.employeeServiceMapper = employeeServiceMapper;
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
	return employeeServiceMapper.fromEmployeeEntityToEmployeeGetBO(employeeEntity)	;
	
	}
	

}
