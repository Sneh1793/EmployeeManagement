package com.sm.service;

import lombok.Data;

@Data
public class EmployeeGetBO extends EmployeeBO {
	private Integer empid;
	private AddressBO addressBO;
}
