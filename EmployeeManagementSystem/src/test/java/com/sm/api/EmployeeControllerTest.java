package com.sm.api;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.sm.repository.EmployeeDao;
import com.sm.service.EmployeeBO;
import com.sm.service.EmployeeGetBO;
import com.sm.service.EmployeeService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {EmployeeController.class})
@WebMvcTest(controllers = {EmployeeController.class})
@AutoConfigureMockMvc
public class EmployeeControllerTest {

	@Mock
	private EmployeeDao employeeDao;
	@Mock
	private EmployeeService employeeService;
	@Spy
	private EmployeeApiMapper employeeApiMapper = new EmployeeApiMapperImpl();

	@InjectMocks
	private EmployeeController employeeController;
	
	private MockMvc mockMvc;
	
	@Test
public void givenEmployees_whensaveEmployees_thenstatus200 () throws Exception {
	
	
		
when(employeeService.saveEmployee(any(EmployeeBO.class))).thenReturn(1)	;
		mockMvc.perform(post("/api/save")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"firstName\":\"Josh\",\"lastName\":\"Nathan\",\"gender\":\'M\',\" pinCode\":226016,\"dateOfBirth\":\"22/07/1996\"}"))
		         .andExpect(status().isCreated())
		         .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
		         .andExpect(header().string("Location", "/api/save/1"))
		         .andExpect(jsonPath("$.employeeid").value(1)) 
		           .andExpect(jsonPath("$.firstName").value("Josh"))
		           .andExpect(jsonPath("$.lastName").value("Nathan"))
		           .andExpect(jsonPath("$.gender").value('M')) 
		           .andExpect(jsonPath("$.pinCode").value(226016)) 
		           .andExpect(jsonPath("$.dateOfBirth").value("22-07-1996"))  
		           .andDo(print());
		}

@Test
public void should_GetEmployees_When_ValidRequest() throws Exception{
	
EmployeeGetBO employeeGetBO = new EmployeeGetBO();
employeeGetBO.setEmpid(1);
employeeGetBO.setFirstName("Josh");
employeeGetBO.setLastName("Nathan");

	when(employeeService.getEmployee(any(Integer.class),any(String.class),any(String.class))).thenReturn(employeeGetBO);
	

	  mockMvc.perform(get("/api/getEmployeeDetails") 
	           .accept(MediaType.APPLICATION_JSON))
	           .andExpect(status().isOk())
	           .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
	           .andExpect(jsonPath("$.Empid").value(12345))
	           .andExpect(jsonPath("$.FirstName").value("Josh"))
	           .andExpect(jsonPath("$.LastName").value("Nathan"));
	
} 

}
