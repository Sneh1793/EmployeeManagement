package com.sm.service;

import java.time.LocalDate;

import lombok.Data;

@Data
public class EmployeeBO {
	//private Integer empid;
	private String firstName;
	private String lastName;
	private char gender;
	private LocalDate dateOfBirth;
}
