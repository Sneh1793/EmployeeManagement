package com.sm.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class EmployeeDaoTests {

	
	@Autowired private EmployeeDao employeedao;
	@BeforeEach
	void setup() {
    EmployeeEntity employeeEntity = new EmployeeEntity();
		
	employeeEntity.setFirstName("Rohan");
	employeeEntity.setLastName("mishra");
	employeeEntity.setGender('m');
	employeeEntity.setDateOfBirth(LocalDate.of(1993, 9, 25));
	employeedao.save(employeeEntity);
	}
	
	@Test
	
	void findByEmployeeIdAndFirstNameAndLastNameEqualTest() {
		 List<EmployeeEntity> employeeEntities= employeedao.findAll();
		 
		 
		 
EmployeeEntity employeeEntity	 = employeedao.findByEmployeeIdAndFirstNameAndLastName(employeeEntities.get(0).getEmployeeId(), "Rohan", "mishra");

	assertEquals("Rohan",employeeEntity.getFirstName());
	
	}

	
}
