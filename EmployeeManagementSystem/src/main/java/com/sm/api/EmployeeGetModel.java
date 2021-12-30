package com.sm.api;

import java.time.LocalDate;

import com.sm.remote.AddressDetailDTO;

import lombok.Data;

@Data
public class EmployeeGetModel extends EmployeeModel {
	private Integer employeeId;
	private AddressModel addressModel;	

}
