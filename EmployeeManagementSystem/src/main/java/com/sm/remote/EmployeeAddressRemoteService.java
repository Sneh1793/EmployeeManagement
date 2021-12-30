package com.sm.remote;

import java.util.List;

public interface EmployeeAddressRemoteService {

	List<AddressDetailDTO> getEmployeeAddress(int pinCode);
	
	
}

