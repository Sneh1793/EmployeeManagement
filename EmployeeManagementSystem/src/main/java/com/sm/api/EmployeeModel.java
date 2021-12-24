package com.sm.api;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.sm.api.validation.GenderValidator;

import lombok.Data;
@Data
public class EmployeeModel {
	//private Integer employeeid;
	
	@Size(min = 3, max = 15)
	@NotBlank
	@Pattern(message=" FirstName is not valid ",regexp="^[a-zA-Z\\\\s]*$")
	private String firstName;
	@Size(min = 3, max = 15)
	@NotBlank
	@Pattern(message=" LastName is not valid ",regexp="^[a-zA-Z\\\\s]*$")
	private String lastName;
	//@NotBlank
	//@Pattern(regexp="[MF]")
	@GenderValidator
	private char gender;
	@PastOrPresent
	private LocalDate dateOfBirth;

}
