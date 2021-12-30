package com.sm.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.sm.api.EmployeeApiMapper;
import com.sm.remote.AddressDetailDTO;
import com.sm.remote.EmployeeAddressRemoteService;
import com.sm.repository.EmployeeDao;
import com.sm.repository.EmployeeEntity;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

	@InjectMocks
	private EmployeeServiceImpl employeeServiceImpl;

	@Mock
	private EmployeeDao employeeDao;
	
	@Mock
	private EmployeeAddressRemoteService employeeAddressRemoteService;

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
	
	@Test
	void getEmployee() {
		EmployeeEntity employeeEntity = new EmployeeEntity();
		
		employeeEntity.setEmployeeId(1);
		employeeEntity.setFirstName("David");	
		employeeEntity.setLastName("Macron");
		employeeEntity.setPinCode(226016);
		
	AddressDetailDTO addressDetailDTO = new AddressDetailDTO();
	addressDetailDTO.setName("Indira Nagar (Lucknow)");
	addressDetailDTO.setBranchType("Sub Post Office");
	addressDetailDTO.setCircle("NA");
	addressDetailDTO.setDistrict("Lucknow");
	addressDetailDTO.setDescription("Lucknow");
	addressDetailDTO.setRegion("Lucknow  HQ");
	addressDetailDTO.setState("Uttar Pradesh");
	addressDetailDTO.setTaluk("NA");
	addressDetailDTO.setCountry("India");
	addressDetailDTO.setDeliveryStatus("Delivery");
	addressDetailDTO.setDivision("Lucknow");
	
	List<AddressDetailDTO> addressDetails = new ArrayList <>();
	addressDetails.add(addressDetailDTO);
	
   when(employeeDao.findByEmployeeIdAndFirstNameAndLastName(any(Integer.class),any(String.class),any(String.class))).thenReturn(employeeEntity);

   when(employeeAddressRemoteService.getEmployeeAddress(any(Integer.class))).thenReturn(addressDetails);	
	
EmployeeGetBO employeeGetBO	= employeeServiceImpl.getEmployee(1, "David", "Macron");
	
    assertEquals(1, employeeGetBO.getEmpid());
    assertEquals("David", employeeGetBO.getFirstName());
    assertEquals("Macron", employeeGetBO.getLastName());
    assertEquals("Indira Nagar (Lucknow)", employeeGetBO.getAddressBO().getName());
	}
}
