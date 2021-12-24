package com.sm.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.sm.api.EmployeeApiMapper;
import com.sm.repository.EmployeeDao;
import com.sm.repository.EmployeeEntity;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

	@InjectMocks
	private EmployeeServiceImpl employeeServiceImpl;

	@Mock
	private EmployeeDao employeeDao;

	@Spy
	private EmployeeServiceMapper employeeServiceMapper = new EmployeeServiceMapperImpl();

	@Test
	void saveEmployeeEntityTest() {
		EmployeeBO employeeBO = new EmployeeBO();
		employeeBO.setFirstName("samy");
		employeeBO.setLastName("manuel");
		employeeBO.setGender('f');
		employeeBO.setDateOfBirth(LocalDate.now());

		EmployeeEntity employeeEntity = new EmployeeEntity();

		employeeEntity.setEmployeeId(345);
		employeeEntity.setFirstName("Rohan");
		employeeEntity.setLastName("mishra");
		employeeEntity.setGender('m');
		employeeEntity.setDateOfBirth(LocalDate.of(1993, 9, 25));

		when(employeeDao.save(any(EmployeeEntity.class))).thenReturn(employeeEntity);
		int employeeid = employeeServiceImpl.saveEmployee(employeeBO);
		assertEquals(345, employeeid);
	}

}
