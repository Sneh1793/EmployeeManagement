package com.sm.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDao extends JpaRepository<EmployeeEntity, Integer> {
	
	
	
	EmployeeEntity findByEmployeeIdAndFirstNameAndLastName(int  employeeid, String firstName, String lastName);
	//Optional<EmployeeEntity> findById(Integer employeeid);
}
