/**
 * 
 */
package com.sm.repository;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author smrd1
 *
 */
@Entity
@Data

@Table(name="employee")
public class EmployeeEntity {
     
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
    
	@Column(name="employee_id")
	private Integer employeeId;
	@Column(name="first_name")
	
	private String firstName;
	@Column(name="last_name")
	
	private String lastName;
	@Column(name="employee_gender")
	private char gender;
	
	@Column(name="pin_code")
	private Integer pinCode;
	
	@Column(name="date_of_birth")
	private LocalDate dateOfBirth;
	
	
}
